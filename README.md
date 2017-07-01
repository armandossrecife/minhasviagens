# minhasviagens
Aplicação android de exemplo - controle simples de viagens

O projeto modelo tem as seguintes configurações:

Compile SDK version API 24: Android 7.0 (Nougat)
Build Tools Version: 25.0.0
Dependências:
- com.android.support:appcompat-v7:24.1.1
- com.android.support:constraint:constraint-layout:1.0.1
- com.google.android.gms:play-services-maps:9.4.0
- junit.junit:4.12

Project
Gradle version: 4.0
Android Plugin Version: 2.3.3
Android Plugin Repository: jcenter

Para abrir o mapa é preciso gerar uma nova chave do google maps e atualizar na sua versão do projeto e atualizar seu valor no arquivo google_mpas_api.xml
..res/values/google_maps_api.xml

Adicionar a referência do valor no arquivo de manifesto
..manifest/AndroidManifest.xml
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_key" />

