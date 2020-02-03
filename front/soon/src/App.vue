<template>
  <v-app >
     <side/>
      <v-content>
      <ImgBanner/>
      <router-view/>
    </v-content>

  </v-app>
</template>

<script>
import side from './components/side'
import ImgBanner from './components/ImgBanner'
export default {
  name: 'App',
  components : {
    side,
    ImgBanner,
  },
};
</script>
