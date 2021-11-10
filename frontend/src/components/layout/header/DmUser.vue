<template>
  <v-menu v-model="menu" offset-y>
    <template v-slot:activator="{ on, attrs }">
      <v-btn left text plain v-bind="attrs" v-on="on" class="text-lowercase">
        <v-avatar left> <v-icon> mdi-account-circle </v-icon></v-avatar>
        {{ "admin" }}
      </v-btn>
    </template>
    <v-card>
      <v-list actionable>
        <v-list-item color="primary">
          <v-list-item-avatar>
            <v-icon> mdi-account-circle </v-icon>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title>{{ "admin" }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

      <v-divider></v-divider>

      <v-list dense>
        <v-list-item @click="changePassword">
          <v-list-item-icon class="mr-1">
            <v-icon small>mdi-account</v-icon></v-list-item-icon
          >
          <v-list-item-content>My Profile</v-list-item-content>
        </v-list-item>
        <v-list-item @click="changeTheme">
          <v-list-item-icon class="mr-1">
            <v-icon small>mdi-cogs</v-icon></v-list-item-icon
          >
          <v-list-item-content>Settings</v-list-item-content>
        </v-list-item>
      </v-list>
      <v-card-actions>
        <v-btn block color="error" small @click="onLogOut">Logout</v-btn>
      </v-card-actions>
    </v-card>
  </v-menu>
</template>

<script>
import { mapMutations } from "vuex";

export default {
  name: "DmUser",
  data: () => ({
    dialog: false,
    menu: false,
    message: false,
    hints: true,
    user: {},
  }),
  created() {
    this.user = this.$store.state.auth.user;
  },
  methods: {
    ...mapMutations({
      logOut: "auth/PURGE_AUTH",
    }),
    changeTheme() {
      this.$vuetify.theme.dark = !this.$vuetify.theme.dark;
      if (this.$vuetify.theme.dark) {
        localStorage.setItem("theme", "dark");
      } else localStorage.setItem("theme", "light");
    },
    changePassword() {
      this.$emit("changePassword");
    },
    onLogOut() {
      this.logOut();
    },
  },
};
</script>

<style scoped></style>
