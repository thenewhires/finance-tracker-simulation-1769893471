<template>
  <div>
    <h2>Add Transaction</h2>
    <input type="text" v-model="description" placeholder="Description" />
    <input type="number" v-model="amount" placeholder="Amount" />
    <button @click="addTransaction">Add</button>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      description: '',
      amount: 0
    }
  },
  methods: {
    async addTransaction() {
      try {
        const transaction = {
          description: this.description,
          amount: this.amount
        }
        const response = await axios.post('http://localhost:8081/api/transaction', transaction) //Bug 1: Wrong endpoint (transaction instead of transactions)
        this.$emit('transaction-added')
        this.description = ''
        this.amount = 0
      } catch (error) {
        console.error('Error adding transaction:', error)
      }
    }
  }
}
</script>