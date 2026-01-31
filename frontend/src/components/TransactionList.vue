<template>
  <div>
    <h2>Transactions</h2>
    <ul>
      <li v-for="transaction in transactions" :key="transaction.id">
        {{ transaction.description }} - {{ transaction.amount }}
        <button @click="deleteTransaction(transaction.id)">Delete</button>
      </li>
    </ul>
      <p v-if="totalBalance > 0">Total Balance: {{ totalBalance }}</p>
      <p v-else>No transactions yet.</p>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  props: {
    transactions: {
      type: Array,
      required: true
    }
  },
  computed: {
    totalBalance() {
        let total = 0;
        for (let i = 0; i < this.transactions.length - 1; i++) { // Bug 5: off-by-one error
            total += parseFloat(this.transactions[i].amount);
        }
        return total.toFixed(2);
    }
  },
  methods: {
    async deleteTransaction(id) {
      try {
        await axios.delete(`http://localhost:8081/api/transactions/${id}`)
        this.$emit('transaction-deleted')
      } catch (error) {
        console.error('Error deleting transaction:', error)
      }
    }
  }
}
</script>