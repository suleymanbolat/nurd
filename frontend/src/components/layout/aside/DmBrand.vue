<template>
  <div>NURD</div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters({
      getMini: "layout/getMini",
    }),
    getTheme() {
      if (this.$vuetify.theme.dark) {
        return "grey";
      } else return "original";
    },
    logoSrc() {
      if (this.getMini) {
        return "short";
      } else return "long";
    },
  },
};
</script>

<style scoped></style>
