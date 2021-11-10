const state = {
  mini: false,
  showAttackList: true,
  botDrawer: false,
  globalDrawer: false,
  isGlobal: false,
  menuItems: [
    {
      title: "ICSPOT",
    },
    {
      title: "Dashboard",
      icon: "mdi-gauge",
      url: "/dashboard",
    },
    {
      title: "Clients",
      icon: "mdi-account-multiple",
      url: "/clients",
    },
    {
      title: "Incidents",
      icon: "mdi-fingerprint",
      url: "/incidents",
    },
    {
      title: "Logs",
      icon: "mdi-file-document-multiple",
      url: "/logs",
    },
    {
      title: "Settings",
    },
    {
      title: "Roles",
      icon: "mdi-shield-star",
      url: "/roles",
    },
    {
      title: "Users",
      icon: "mdi-account-group",
      url: "/users",
    },
    {
      title: "Customers",
      icon: "mdi-handshake",
      url: "/customers",
    },
  ],
};

const getters = {
  getMini(state) {
    return state.mini;
  },
  getMenuItems(state) {
    return state.menuItems;
  },
};

const mutations = {
  SET_MINI(state) {
    state.mini = !state.mini;
  },
};

export default {
  namespaced: true,
  state,
  mutations,
  getters,
};
