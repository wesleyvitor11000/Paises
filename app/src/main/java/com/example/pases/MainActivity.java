package com.example.pases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //***************APENAS PARA TESTE*********************
        String paisesText = "#\n" +
                "area: 242495\n" +
                "capital: Londres\n" +
                "continent: Europa\n" +
                "currency: Libras\n" +
                "description: Reino Unido, oficialmente Reino Unido da Grã-Bretanha e Irlanda do Norte, é um Estado soberano insular localizado em frente à costa noroeste do continente europeu. O atual Reino Unido foi formado após o surgimento do Estado Livre Irlandês em 1922, que ganhou independência da coroa britânica. O Reino Unido é uma união política de quatro \"países constituintes\": Escócia, Inglaterra, Irlanda do Norte e País de Gales. O governo é regido por um sistema parlamentar, cuja sede está localizada na cidade de Londres, a capital, e por uma monarquia constitucional que tem a rainha Isabel II como a chefe de Estado.\n" +
                "icon: united-kingdom.png\n" +
                "image: uk.jpg\n" +
                "image-author: Giuseppe Milo\n" +
                "image-name: Tower bridge - London, United Kingdom\n" +
                "language: Inglês\n" +
                "name: Reino Unido\n" +
                "population: 68455083\n" +
                "url: https://www.flickr.com/photos/giuseppemilo/45679070022\n" +
                "\n" +
                "#\n" +
                "area: 9371175\n" +
                "capital: Washington\n" +
                "continent: América do Norte\n" +
                "currency: Dólar\n" +
                "description: Estados Unidos da América são uma república constitucional federal composta por 50 estados e um distrito federal. A maior parte do país situa-se na região central da América do Norte, formada por 48 estados e o Distrito de Colúmbia, o distrito federal da capital. Os Estados Unidos são uma das nações mais multiculturais e etnicamente diversas do mundo, produto da forte imigração vinda de muitos países. Sua geografia e sistemas climáticos também são extremamente diversificados, com desertos, planícies, florestas e montanhas que abrigam uma grande variedade de espécies.\n" +
                "icon: united-states.png\n" +
                "image: usa.jpg\n" +
                "image-author: Ed Uthman\n" +
                "image-name: United States Capitol\n" +
                "language: Inglês\n" +
                "name: Estados Unidos da América\n" +
                "population: 331449281\n" +
                "url: https://www.flickr.com/photos/euthman/30079937645\n" +
                "\n" +
                "#\n" +
                "area: 92256\n" +
                "capital: Lisboa\n" +
                "continent: Europa\n" +
                "currency: Euro\n" +
                "description: Portugal, oficialmente República Portuguesa, é um país soberano unitário localizado no sudoeste da Europa, cujo território se situa na zona ocidental da Península Ibérica e em arquipélagos no Atlântico Norte. O território português tem uma área total de 92 090 km², sendo delimitado a norte e leste por Espanha e a sul e oeste pelo oceano Atlântico, compreendendo uma parte continental e duas regiões autónomas: os arquipélagos dos Açores e da Madeira. Portugal é a nação mais a ocidente do continente europeu. O nome do país provém da sua segunda maior cidade, Porto, cujo nome latino-celta era Portus Cale.\n" +
                "icon: portugal.png\n" +
                "image: pt.jpg\n" +
                "image-author: Vitor Oliveira\n" +
                "image-name: Lisboa - Portugal\n" +
                "language: Português\n" +
                "name: Portugal\n" +
                "population: 10347892\n" +
                "url: https://www.flickr.com/photos/vitor107/22462269442\n" +
                "\n" +
                "#\n" +
                "area: 8510345\n" +
                "capital: Brasília\n" +
                "continent: América do Sul\n" +
                "currency: Real\n" +
                "description: Brasil é o maior país da América do Sul e da região da América Latina, sendo o quinto maior do mundo em área territorial, com 8 510 345,538 km² e sexto em população. É o único país na América onde se fala majoritariamente a língua portuguesa e o maior país lusófono do planeta, além de ser uma das nações mais multiculturais e etnicamente diversas, em decorrência da forte imigração oriunda de variados locais do mundo. Sua atual Constituição, promulgada em 1988, concebe o Brasil como uma república federativa presidencialista, formada pela união dos 26 estados, do Distrito Federal e dos 5 570 municípios.\n" +
                "icon: brazil.png\n" +
                "image: bra.jpg\n" +
                "image-author: Revol Web\n" +
                "image-name: Brasil\n" +
                "language: Português\n" +
                "name: Brasil\n" +
                "population: 213317639\n" +
                "url: https://www.flickr.com/photos/revolweb/15956587634\n" +
                "\n" +
                "#\n" +
                "area: 22072\n" +
                "capital: Jerusalém\n" +
                "continent: Oriente Médio\n" +
                "currency: Novo Shekel\n" +
                "description: Israel é uma democracia parlamentar localizada no Oriente Médio, ao longo da costa oriental do Mar Mediterrâneo. O país faz fronteira com o Líbano ao norte, com a Síria a nordeste, com a Jordânia e a Cisjordânia a leste, com o Egito e a Faixa de Gaza ao sudoeste, e com o Golfo de Aqaba, no Mar Vermelho, ao sul. Geograficamente, contém diversas características dentro de seu território relativamente pequeno. Israel é definido como um \"Estado Judeu e Democrático\" em suas Leis Básicas e é o único Estado de maioria judia do mundo. O centro financeiro de Israel é Telavive, enquanto Jerusalém é a cidade mais populosa do país e sua capital.\n" +
                "icon: israel.png\n" +
                "image: il.jpg\n" +
                "image-author: Joachim Tuns\n" +
                "image-name: Jerusalem\n" +
                "language: Hebraico\n" +
                "name: Israel\n" +
                "population: 9069960\n" +
                "url: https://www.flickr.com/photos/61168666@N00/14810008360\n" +
                "\n" +
                "#\n" +
                "area: 337975\n" +
                "capital: Tóquio\n" +
                "continent: Ásia\n" +
                "currency: Iene\n" +
                "description: Japão é um país insular da Ásia Oriental. Localizado no Oceano Pacífico, a leste do Mar do Japão, da República Popular da China, da Coreia do Norte, da Coreia do Sul e da Rússia, se estendendo do Mar de Okhotsk, no norte, ao Mar da China Oriental e Taiwan, ao sul. Os caracteres que compõem seu nome significam \"Origem do Sol\", razão pela qual o Japão é às vezes identificado como a \"Terra do Sol Nascente\". Como grande potência econômica, possui a terceira maior economia do mundo em PIB nominal e a quarta maior em poder de compra. É também o quarto maior exportador e o quarto maior importador do mundo, além de ser o único país asiático membro do G7.\n" +
                "icon: japan.png\n" +
                "image: jpn.jpg\n" +
                "image-author: Francisco Frestivo\n" +
                "image-name: Shibuya\n" +
                "language: Japonês\n" +
                "name: Japão\n" +
                "population: 126444000\n" +
                "url: https://www.flickr.com/photos/frestivo/4786015857\n" +
                "\n" +
                "#\n" +
                "area: 9596961\n" +
                "capital: Pequim\n" +
                "continent: Ásia\n" +
                "currency: Renminbi\n" +
                "description: República Popular da China, também conhecida simplesmente como China, é o maior país da Ásia Oriental e o mais populoso do mundo, com mais de 1,38 bilhão de habitantes, quase um quinto da população da Terra. É uma república popular socialista unipartidária. Na constituição, descreve-se como um sistema multipartidário de cooperação e consulta política sob a liderança do Partido Comunista da China e como uma \"ditadura democrática popular liderada pela classe trabalhadora e baseada na aliança de trabalhadores e camponeses\".\n" +
                "icon: china.png\n" +
                "image: chn.jpg\n" +
                "image-author: Diego Aviles\n" +
                "image-name: China\n" +
                "language: Mandarim\n" +
                "name: China\n" +
                "population: 1397897720\n" +
                "url: https://www.flickr.com/photos/diegoaviles/9521940433\n" +
                "\n";
        //******************************************************


        Toolbar topBar = findViewById(R.id.topbar);

        setSupportActionBar(topBar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("");
        }

        ArrayList<Pais> paises = PaisesManager.getPaisesFromString(paisesText);

        RecyclerView paises_recycle = findViewById(R.id.country_recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        PaisesAdapter paisesAdapter = new PaisesAdapter(paises);
        paises_recycle.setLayoutManager(linearLayoutManager);
        paises_recycle.setAdapter(paisesAdapter);

    }
}