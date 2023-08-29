package com.example.contactapp

data class Profile (
    val imageResourceId : Int,
    val name : String,
    val number : String,
    var bookmark : Boolean,


        )
object ProfileList{
    val profiles = mutableListOf<Profile>()
    init {

        val profile1 = Profile(
            imageResourceId = R.drawable.dltkd,
            name = "Kim Ru Ry",
            number = "010-1234-5675",
            bookmark =false
        )
        profiles.add(profile1)

        val profile2 = Profile(
            imageResourceId = R.drawable.pica1,
            name = "Park Kim",
            number = "010-1234-5875",
                    bookmark =false
        )
        profiles.add(profile2)

        val profile3 = Profile(
            imageResourceId = R.drawable.pa2,
            name = "Kim Kadasian",
            number = "010-7777-7777",
            bookmark =false
        )
        profiles.add(profile3)

        val profile4 = Profile(
            imageResourceId = R.drawable.pa1,
            name = "jo kim",
            number = "010-5751-7777",
            bookmark =false
        )
        profiles.add(profile4)

        val profile5 = Profile(
            imageResourceId = R.drawable.gobuk1,
            name = "Picachu",
            number = "010-7777-1223",
            bookmark =false
        )
        profiles.add(profile5)

        val profile6 = Profile(
            imageResourceId = R.drawable.pa3,
            name = "Bok Soon e",
            number = "010-4444-4444",
            bookmark =false
        )
        profiles.add(profile6)

        val profile7 = Profile(
            imageResourceId = R.drawable.pica3,
            name = "Sip sa",
            number = "010-7889-4211",
            bookmark =false
        )
        profiles.add(profile7)

        val profile8 = Profile(
            imageResourceId = R.drawable.dltkd3,
            name = "Gab soon ja",
            number = "010-7777-7891",
            bookmark =false
        )
        profiles.add(profile8)

        val profile9 = Profile(
            imageResourceId = R.drawable.pica2,
            name = "Man wall e",
            number = "010-1111-7111",
            bookmark =false
        )
        profiles.add(profile9)

        val profile10 = Profile(
            imageResourceId = R.drawable.gobuk2,
            name = "Dong soon ",
            number = "010-8888-9999",
            bookmark =false
        )
        profiles.add(profile10)

        val profile11 = Profile(
            imageResourceId = R.drawable.gobuk3,
            name = "Cat",
            number = "010-7777-6666",
            bookmark =false
        )
        profiles.add(profile11)

        val profile12 = Profile(
            imageResourceId = R.drawable.dltkd2,
            name = "Trash",
            number = "010-5555-5555",
            bookmark =false
        )
        profiles.add(profile12)



    }
}
