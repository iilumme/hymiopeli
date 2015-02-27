# **Rakennekuvaus**

Aluksi käynnistetään Kayttoliittyma-olio, joka luo pelin graaffisen käyyöliittymän, Main-luokassa.

**Kayttoliittyma-olio** luo yhdet

    Piirtoalusta-, 
    HymioPeli-, 
    Apuri- 
    ja NappaimistonKuuntelija-oliot
    
ja asettaa 

      HymioPeli-oliolle Apuri-olion, 
      omalle JFrame-oliolleen ja HymioPeli-oliolle NappaimistonKuuntelija-olion 
      HymioPeli-oliolle Piirtoalusta-olion.

**Piirtoalusta** on alue, jolle pelihahmot luodaan ja jolla siis myös pelataan. Kun Piirtoalusta-olio luodaan mukaan annetaan HymioPeli.

**HymioPeli** on koko pelin aivot, eli se luo pelitilanteen, pitää sitä yllä ja päivittää. Hymiopeli-olio luo pelin hahmot eli Pelaaja-oliot(Hymio/Tiikeri/IronMan-oliot) ja Vastus-oliot(Surullinen/Kissa/Killian-oliot).

**Pelaaja ja Vastus** luokat eriyttävät Hahmo luokan hahmot kahteen erilaiseen pelihahmoon. Pelaaja-olio on käyttäjän pelihahmo, jolla pelataan. Vastus-olio on hahmo, joka on tarkoitus muuttaa Pelaaja-oliolla.

**Apuri-olio** auttaa luokkien välisissä yhteyksissä. Luodessa annetaan sille parametreissä HymioPeli-olio ja Kayttoliittyma-olio.
Apuri taas luo yhdet 

    HighScoreTallentaja-,
    KieliPanel-,
    HahmoPanel-,
    ValikkoPanel-, 
    TietoPanel-,
    ja Viestiapuri-oliot
    
joille kaikille, paitsi HighScoreTallentaja-oliolle, annetaan Apuri-olio parametreihin.

**NappaimistonKuuntelija-olio** kuuntelee näppäimistöä ja siirtää pelihahmoa. Luodessa parametreissä annetaan HymioPeli ja Piirtoalusta.

**KieliPanel-olio** on pelin alussa nähtävä kolmen JButtonin JPanel, jossa valitaan kieli. KieliPanel-olio luo kaikille JButton-olioillensa

    KieliNapinKuuntelija-olion,

joka saa parametreissä kyseisen JButtonin ja Apuri-olion.

**ValikkoPanel-olio** on neljän JButtonin JPanel, jossa voidaan valita uusi peli aloitettavaksi, highscoret tai ohjeet nähtäväksi tai poistua pelistä. ValikkoPanel-olio luo kaikille JButton-olioillensa

    ValikkoNapinKuuntelija-olion,

joka saa parametreissä kyseisen JButtonin ja Apuri-olion.

**HahmoPanel-oliokin** on kolmen JButtonin JPanel, jossa valitaan pelihahmo. HahmoPanel-olio luo kaikille JButton-olioillensa

    HahmoNapinKuuntelija-olion,

joka saa parametreissä kyseisen JButtonin ja Apuri-olion.

**TietoPanel-olio** on neljän JLabelin ja yhden JButtonin JPanel, joka näyttää pelitilanteen tietoja ja jossa on Lopeta-nappi, jolla voidaan lopettaa peli. TietoPanel-olio luo yhdella JButton-oliollensa

    PoistuNapinKuuntelija-olion,

joka saa parametreissä tämän JButtonin ja Apuri-olion.

**Viestiapuri-olio** antaa käytettäväksi muille olioille JOptionPanes.  

**HighScoreTallentaja-olio** pitää huolta highscoretietojen hakemisesta tiedostosta, viemisestä tiedostoon ja käytettäväksi antamisesta. Luo 

    HighScore-olioita,

tarpeen mukaan.

**HighScore-olio** tallentaa itselleen tiedon pelaajan nimestä ja pisteistä.

**Kuuntelijat** kuuntelevat niille annettuja JButtoneita ja tekevät toimintoja.
