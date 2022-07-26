<template>

    <v-data-table
        :headers="headers"
        :items="roomview"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'RoomviewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "roomId", value: "roomId" },
                { text: "desciption", value: "desciption" },
                { text: "reviewCnt", value: "reviewCnt" },
                { text: "roomStatus", value: "roomStatus" },
                { text: "rsvId", value: "rsvId" },
                { text: "rsvStatus", value: "rsvStatus" },
                { text: "payId", value: "payId" },
                { text: "payStatus", value: "payStatus" },
            ],
            roomview : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/roomviews'))

            temp.data._embedded.roomviews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.roomview = temp.data._embedded.roomviews;
        },
        methods: {
        }
    }
</script>

