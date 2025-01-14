package com.example.appclonesprotify.ui.signup

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclonesprotify.R

class ChooseArtists: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_choose_artisit)

        val artists = listOf(
            Artist("Billie Eilish", "@drawable/billie_eilish"),
            Artist("Kanye West", "https://example.com/kanye_west.jpg"),
            Artist("Ariana Grande", "https://example.com/ariana_grande.jpg"),
            Artist("Lana Del Rey", "https://example.com/lana_del_rey.jpg"),
            Artist("BTS", "https://example.com/bts.jpg"),
            Artist("Drake", "https://example.com/drake.jpg"),
            Artist("Harry Styles", "https://example.com/harry_styles.jpg"),
            Artist("One Direction", "https://example.com/one_direction.jpg"),
            Artist("Rihanna", "https://example.com/rihanna.jpg"),
            Artist("Ed Sheeran", "https://example.com/ed_sheeran.jpg"),
            Artist("The Weeknd", "https://example.com/the_weeknd.jpg"),
            Artist("Dua Lipa", "https://example.com/dua_lipa.jpg"),

            Artist("Taylor Swift", "https://example.com/taylor_swift.jpg"),
            Artist("Beyoncé", "https://example.com/beyonce.jpg"),
            Artist("Justin Bieber", "https://example.com/justin_bieber.jpg"),
            Artist("Adele", "https://example.com/adele.jpg"),
            Artist("Bruno Mars", "https://example.com/bruno_mars.jpg"),
            Artist("Maroon 5", "https://example.com/maroon_5.jpg"),
            Artist("Coldplay", "https://example.com/coldplay.jpg"),
            Artist("Imagine Dragons", "https://example.com/imagine_dragons.jpg"),
            Artist("Shawn Mendes", "https://example.com/shawn_mendes.jpg"),
            Artist("Camila Cabello", "https://example.com/camila_cabello.jpg"),
            Artist("Post Malone", "https://example.com/post_malone.jpg"),
            Artist("Selena Gomez", "https://example.com/selena_gomez.jpg"),
            Artist("Lady Gaga", "https://example.com/lady_gaga.jpg"),
            Artist("Katy Perry", "https://example.com/katy_perry.jpg"),
            Artist("Eminem", "https://example.com/eminem.jpg"),
            Artist("Kendrick Lamar", "https://example.com/kendrick_lamar.jpg"),
            Artist("Drake", "https://example.com/drake.jpg"), // Duplicate to show more than 50
            Artist("The Beatles", "https://example.com/the_beatles.jpg"),
            Artist("Queen", "https://example.com/queen.jpg"),
            Artist("Michael Jackson", "https://example.com/michael_jackson.jpg"),
            Artist("Elton John", "https://example.com/elton_john.jpg"),
            Artist("David Bowie", "https://example.com/david_bowie.jpg"),
            Artist("Prince", "https://example.com/prince.jpg"),
            Artist("Madonna", "https://example.com/madonna.jpg"),
            Artist("Whitney Houston", "https://example.com/whitney_houston.jpg"),
            Artist("Mariah Carey", "https://example.com/mariah_carey.jpg"),
            Artist("Celine Dion", "https://example.com/celine_dion.jpg"),
            Artist("Alicia Keys", "https://example.com/alicia_keys.jpg"),
            Artist("John Legend", "https://example.com/john_legend.jpg"),
            Artist("Sam Smith", "https://example.com/sam_smith.jpg"),
            Artist("Hozier", "https://example.com/hozier.jpg"),
            Artist("Lewis Capaldi", "https://example.com/lewis_capaldi.jpg"),
            Artist("Billie Joel", "https://example.com/billie_joel.jpg"),
            Artist("Billy Idol", "https://example.com/billy_idol.jpg"),
            Artist("Bob Dylan", "https://example.com/bob_dylan.jpg"),
            Artist("Bruce Springsteen", "https://example.com/bruce_springsteen.jpg"),
            Artist("Cher", "https://example.com/cher.jpg"),
            Artist("Christina Aguilera", "https://example.com/christina_aguilera.jpg"),
            Artist("Daft Punk", "https://example.com/daft_punk.jpg"),
            Artist("Dolly Parton", "https://example.com/dolly_parton.jpg"),
            Artist("Foo Fighters", "https://example.com/foo_fighters.jpg"),
            Artist("Green Day", "https://example.com/green_day.jpg"),
            Artist("Guns N' Roses", "https://example.com/guns_n_roses.jpg"),
            Artist("Janet Jackson", "https://example.com/janet_jackson.jpg"),
            Artist("Jay-Z", "https://example.com/jay_z.jpg"),
            Artist("John Mayer", "https://example.com/john_mayer.jpg"),
            Artist("Joni Mitchell", "https://example.com/joni_mitchell.jpg"),
            Artist("Kanye West", "https://example.com/kanye_west.jpg"), // Duplicate to show more than 50
            Artist("Kiss", "https://example.com/kiss.jpg"),
            Artist("Linkin Park", "https://example.com/linkin_park.jpg"),
            Artist("Metallica", "https://example.com/metallica.jpg"),
            Artist("Nirvana", "https://example.com/nirvana.jpg"),
            Artist("Paul McCartney", "https://example.com/paul_mccartney.jpg"),
            Artist("Pink Floyd", "https://example.com/pink_floyd.jpg"),
            Artist("Red Hot Chili Peppers", "https://example.com/red_hot_chili_peppers.jpg"),
            Artist("Stevie Wonder", "https://example.com/stevie_wonder.jpg"),
            Artist("U2", "https://example.com/u2.jpg")
        )

        val recyclerView: RecyclerView = findViewById(R.id.artistsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ArtistAdapter(artists)
    }
}