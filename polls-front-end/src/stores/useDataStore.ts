import axios from "axios";
import { defineStore } from "pinia";

interface State {
  polls: any[];
  loading: boolean;
  error: string | null;
}

const POLL_URL = "http://localhost:8080/api/polls";

export const useDataStore = defineStore("data", {
  state: (): State => ({
    polls: [],
    loading: false,
    error: null,
  }),
  actions: {
    async fetchData() {
      this.loading = true;
      this.error = null;
      try {
        const response = await axios.get(POLL_URL);
        this.polls = response.data;
      } catch (error) {
        this.error =
          error instanceof Error ? error.message : "An error occurred";
      } finally {
        this.loading = false;
      }
    },
  },
});
