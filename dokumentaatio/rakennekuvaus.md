**Rakennekuvaus**

Aluksi käynnistetään Kayttoliittyma-olio Main-luokassa.

**Kayttoliittyma-olio** luo yhdet

    Piirtoalusta-, 
    HymioPeli-, 
    Apuri- 
    ja NappaimistonKuuntelija-oliot
    
ja asettaa 

      HymioPeli-oliolle Apuri-olion, 
      omalle JFrame-oliolleen ja HymioPeli-oliolle NappaimistonKuuntelija-olion 
      HymioPeli-oliolle Piirtoalusta-olion.

**Piirtoalustaa** luodessa mukaan annetaan HymioPeli.

**HymioPeli** luo pelin hahmot eli Hymio/Tiikeri/IronMan-oliot ja Surullinen/Kissa/Killian-oliot.

**Apuri-oliota** luodessa annetaan sille parametreissä HymioPeli-olio ja Kayttoliittyma-olio.
Apuri taas luo yhdet 

    HighScoreTallentaja-,
    KieliPanel-,
    HahmoPanel-,
    ValikkoPanel- 
    ja TietoPanel-oliot,
    
joille kaikille, paitsi HighScoreTallentaja-oliolle, annetaan Apuri-olio parametreihin.

**NappaimistonKuuntelija-oliota** luodessa parametreissä annetaan HymioPeli ja Piirtoalusta.

**KieliPanel-olio** luo kaikille JButton-olioillensa

    KieliNapinKuuntelija-olion,

joka saa parametreissä kyseisen JButtonin ja Apuri-olion.

**ValikkoPanel-olio** luo kaikille JButton-olioillensa

    ValikkoNapinKuuntelija-olion,

joka saa parametreissä kyseisen JButtonin ja Apuri-olion.

**HahmoPanel-oliokin** luo kaikille JButton-olioillensa

    HahmoNapinKuuntelija-olion,

joka saa parametreissä kyseisen JButtonin ja Apuri-olion.

**TietoPanel-olio** luo yhdella JButton-oliollensa

    PoistuNapinKuuntelija-olion,

joka saa parametreissä tämän JButtonin ja Apuri-olion.

**HighScoreTallentaja-olio** luo 

    HighScore-olioita,

tarpeen mukaan.


