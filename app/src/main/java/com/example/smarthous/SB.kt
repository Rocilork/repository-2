package com.example.smarthous

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SB {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://prldqfqaxwcsbbwjycgt.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBybGRxZnFheHdjc2Jid2p5Y2d0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDEwNjk5OTEsImV4cCI6MjAxNjY0NTk5MX0.-NFmn1HBbtg5IPS7d6X3j5mvph_ofAMWvgxeTUuCTak"
    ) {
        install(GoTrue)
        install(Postgrest)
        install(Storage)
        //install other modules
    }
    public fun getClient(): SupabaseClient {
        return supabase
    }
}