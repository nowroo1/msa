<template>

    <v-card outlined>
        <v-card-title>
            Roomview # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="RoomId" v-model="item.roomId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Desciption" v-model="item.desciption" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ReviewCnt" v-model="item.reviewCnt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="RoomStatus" v-model="item.roomStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RsvId" v-model="item.rsvId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RsvStatus" v-model="item.rsvStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PayId" v-model="item.payId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="PayStatus" v-model="item.payStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'RoomviewViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/roomviews/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

