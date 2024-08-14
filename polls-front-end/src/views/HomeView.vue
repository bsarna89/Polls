<script setup lang="ts">
import PollCard from "../components/PollCard/PollCard.vue";
import { onMounted, computed, ref } from "vue";
import { useDataStore } from "@/stores/useDataStore";
import { copy } from "../assets/copy";

// Prime Vue Imports//
import ProgressSpinner from "primevue/progressspinner";
import Listbox from "primevue/listbox";

const { homePage } = copy;
const store = useDataStore();

const polls = computed(() => store.polls);
const loading = computed(() => store.loading);
const error = computed(() => store.error);

const selectedPoll = ref<any>(null);
const pollsList = computed(() =>
  store.polls
    .filter((poll) => poll.active)
    .map((poll) => ({ name: poll.question, pollDetails: poll }))
);

onMounted(() => {
  store.fetchData();
});
</script>

<template>
  <div>
    <h1 class="header">{{ homePage.header }}</h1>
    <div v-if="loading" class="loader">
      <ProgressSpinner />
    </div>
    <div v-if="error">{{ homePage.error }}{{ error }}</div>
    <h2 class="header">{{ homePage.activeList }}</h2>
    <div v-if="!loading && !error" class="list">
      <Listbox
        v-model="selectedPoll"
        :options="pollsList"
        filter
        optionLabel="name"
        class="w-full md:w-56"
      />
    </div>

    <div v-if="selectedPoll" class="poll">
      <PollCard :poll="selectedPoll?.pollDetails" />
    </div>
  </div>
</template>

<style scoped>
.header {
  text-align: center;
  margin-bottom: 10px;
}
.loader {
  display: flex;
  justify-content: center;
  align-items: center;
}
.list {
  margin-bottom: 30px;
}
.poll {
  display: flex;
  justify-content: center;
  align-items: center;
}
.w-full {
  width: 100%;
}
</style>
