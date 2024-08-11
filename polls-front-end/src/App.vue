<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
import NavBar from "./components/NavBar/NavBar.vue";
</script>

<template>
  <header>
    <NavBar />
  </header>
  <main>
    <RouterView />
  </main>
</template>

<style scoped>
header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
