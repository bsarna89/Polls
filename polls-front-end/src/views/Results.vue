<script setup>
import PollChart from "../components/PollChart/PollChart.vue";
import { onMounted, computed, ref } from "vue";
import { useDataStore } from "@/stores/useDataStore";
import { copy } from "../assets/copy.ts";

const { results } = copy;
const store = useDataStore();

const polls = computed(() => store.polls.filter((poll) => !poll.active));
const displayNoResults = polls.value.length === 0;

onMounted(() => {
  store.fetchData();
});
</script>

<template>
  <div>
    <h1 class="h1">{{ results.header }}</h1>
    <div v-if="displayNoResults">
      <h2>{{ results.noResults }}</h2>
    </div>
    <div v-for="poll in polls" :key="poll.id" class="result">
      <h3 class="h3">{{ poll.question }}</h3>
      <PollChart :poll="poll" />
    </div>
  </div>
</template>

<style>
.h1,
h2 {
  margin-bottom: 20px;
  text-align: center;
}
.result {
  margin-bottom: 20px;
  padding: 20px;
}
.h3 {
  margin-bottom: 10px;
}
</style>
