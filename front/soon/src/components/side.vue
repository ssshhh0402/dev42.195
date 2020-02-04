<template>
    <header style="min-height:0">
        <v-app-bar fixed elevate-on-scroll class="container-fluid" style="width:100%;z-index:2">
            <v-toolbar-title class="col-2">
                <router-link to="/" tag="span" style="cursor:pointer; font-weight:bold"> 
                <v-img
                width="130px"
                height="80px"
                src="https://files.slack.com/files-pri/TS565PB7V-FTEGLM6H4/______1.png"
                contain
                >
                </v-img>
                </router-link> 
            </v-toolbar-title>
            <v-container class="d-flex justify-center col-6 offset-1" style="min-height:0" >
                <v-text-field solo rounded label='검색' hide-details="auto"  style="border: yellow solid 2.5px;"></v-text-field>
            </v-container>
            <v-toolbar-items class="col-4 justify-start" >
                <v-btn
                text
                large
                v-for="item in menuItems"
                :key="item.title"
                color="white"
                :to="item.path"
                style="text-align:center;">
                <h2 style="font-weight:bold;font-size:1.5rem;">{{item.title}}</h2>
            </v-btn>
            </v-toolbar-items>
        </v-app-bar>
    </header>
</template>
<script>

export default {
    name : 'side',
    data(){
        return {
            menuItems:[
                {title: '신청하기', path: '/join', icon: 'note_add'},
                {title:'만들기', path: '/create', icon: 'public'},
                {title: '내 정보', path: '/my', icon: 'person'}
            ]
        }
    },
    methods: {

    }
}
</script>
 <style>
 .v-toolbar__content {
     background:#424242 !important;
 }

 </style>