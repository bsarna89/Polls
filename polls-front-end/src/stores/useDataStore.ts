import { defineStore } from "pinia";
import axios from "axios";


interface State {
  polls: any[];
  loading: boolean;
  error: string | null;
}

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
        const response = await axios.get("http://localhost:8080/api/polls");
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
