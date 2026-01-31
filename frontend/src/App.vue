<template>
  <div id="app">
    <h1>Finance Tracker</h1>
    <TransactionForm @transaction-added="fetchTransactions" />
    <TransactionList :transactions="transactions" @transaction-deleted="fetchTransactions" />
  </div>
</template>

<script>
import TransactionForm from './components/TransactionForm.vue'
import TransactionList from './components/TransactionList.vue'
import axios from 'axios'

export default {
  components: {
    TransactionForm,
    TransactionList
  },
  data() {
    return {
      transactions: []
    }
  },
  mounted() {
    this.fetchTransactions()
  },
  methods: {
    async fetchTransactions() {
      try {
        const response = await axios.get('http://localhost:8081/api/transactions');
        this.transactions = response.data;
      } catch (error) {
        console.error('Error fetching transactions:', error);
      }
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>