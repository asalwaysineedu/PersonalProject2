<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="12">
        <v-text-field
          v-model="search"
          append-icon="mdi-magnify"
          label="제목을 입력하세요."
          single-line
          outlined
          dense
          rounded
          color="#2a46ff"
          hide-details></v-text-field>
        </v-col>

    <v-col cols="12">
      <v-data-table
      :headers="headers"
      :items="desserts"
      :search="search"
      hide-default-footer></v-data-table>
    </v-col>

      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: 'NoticeList',
  props: {
    noticeBoards: {
      type: Array
    }
  },
}
</script>

<style lang="scss" scoped>

    .v-text-field {
        font-size: 0.85rem;
    
    .v-text-field >>> label {
        font-size: 0.85rem;
    }
  }
    

</style>