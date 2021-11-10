import axios from "axios";
import { saveToken, getToken } from "@/services/jwt.service";
import router from "@/router";

let baseUrl =
  process.env.NODE_ENV === "production"
    ? "/api/"
    : "http://localhost:8098/api/";
const $axios = axios.create({
  baseURL: baseUrl,
  headers: {
    "Access-Control-Allow-Origin": "http://localhost:8080",
    "Content-Type": "application/json;charset=utf-8",
  },
});

$axios.interceptors.request.use(
  (config) => {
    const token = getToken();
    if (token) {
      config.headers["Authorization"] = token;
    }
    return config;
  },
  (error) => {
    Promise.reject(error).then(() => {});
  }
);

$axios.interceptors.response.use(
  (response) => {
    return response;
  },
  function (error) {
    const originalRequest = error.config;
    console.log(originalRequest);
    if (
      error.response.status === 401 &&
      originalRequest.url === baseUrl + "token/refresh/"
    ) {
      router.push("/login");
      return Promise.reject(error);
    }

    if (error.response.status === 403 && !originalRequest._retry) {
      originalRequest._retry = true;
      const refreshToken = getRefresh();
      return $axios
        .post("token/refresh/", {
          refresh: refreshToken,
        })
        .then((res) => {
          if (res.status === 200) {
            saveToken(res.data.access);
            $axios.defaults.headers.common["Authorization"] =
              "Bearer " + getToken();
            return $axios(originalRequest);
          }
        });
    }
    return Promise.reject(error);
  }
);

export default $axios;
