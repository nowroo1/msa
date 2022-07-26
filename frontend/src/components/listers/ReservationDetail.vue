<template>
    <v-card outlined>
        <v-card-title>
            Reservation # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="RsvId" v-model="item.rsvId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RoomId" v-model="item.roomId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PayId" v-model="item.payId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'ReservationDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/reservations/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
