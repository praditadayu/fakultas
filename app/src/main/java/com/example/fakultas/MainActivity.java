package com.example.fakultas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    private ArrayList<String> NamaFakultas = new ArrayList<>();
    private ArrayList<String> NamaOrganisasiMahasiswa = new ArrayList<>();
    private ArrayList<String> LokasiFakultas = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailFakultas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();

        if (savedInstanceState == null) {
            setActionBarTitle("Fakultas di Universitas Udayana");
            showListActivity();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            setMode(stateMode);
        }
    }
    private void initImageBitmaps() {

        LinkGambar.add("https://smfibunud.files.wordpress.com/2017/01/cropped-122991.png?w=604");
        NamaFakultas.add("Fakultas Ilmu Budaya");
        NamaOrganisasiMahasiswa.add("SMFIB");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Program S1 terdiri dari Sastra Inggris, Sastra Jepang, Sastra Indonesia, Sastra Jawa Kuno, Sastra Bali, Arkeologi, Antropologi, Sejarah, Bahasa Prancis.\n" +
                "Program S2 terdiri dari Ilmu Linguistik dan Kajian Budaya\n" +
                "Program S3 terdiri dari Ilmu Linguistik dan Kajian Budaya");

        LinkGambar.add("http://bemfkunud.com/uploads/2016/06/bem-good.png");
        NamaFakultas.add("Fakultas Kedokteran");
        NamaOrganisasiMahasiswa.add("BEMFK");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman ");
        DetailFakultas.add("Program Studi S1 terdiri dari Dokter, Fisioterapi, Dokter Gigi, Psikologi, Keperawatan, Kesehatan Masyarakat\n" +
                "Program Studi Profesi terdiri dari Dokter, Fisioterapi, Dokter Gigi, Ners\n" +
                "Program Studi Spesialis terdiri dari Ilmu Penyakit Dalam, Ilmu Bedah, Ilmu Kesehatan Anaka, Obsentri dan Ginekologi, Psikiantri, Ilmu penyakit THT-KL, Ilmu Patologi Anatomi, Ilmu Kesehatan Kulit dan Kelamin, Ilmu Penyakit Saraf, Anestesisologi dan Terapi Intensif, Ilmu Kesehatan Mata, Ilmu Penyakit Jantung dan Pembuluh Darah, Ilmu Bioklinik, Radiologi, Bedah Plastik Rekonduksi dan Estetik, Patologi Klinik, Ilmu Penyakit Paru");

        LinkGambar.add("https://sinmawa.unud.ac.id/img/admin/p_desk/63cdafe2bfbfaf89da5fa261aed6043f.png");
        NamaFakultas.add("Fakultas Hukum");
        NamaOrganisasiMahasiswa.add("BEMFH");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Program Studi : Ilmu Hukum");

        LinkGambar.add("https://ft.unud.ac.id/uploads/page/6457b3fa07ea39eed825a0f014900231.png");
        NamaFakultas.add("Fakultas Teknik");
        NamaOrganisasiMahasiswa.add("SMFT");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 5 Program Studi yaitu Teknik Sipil, Arsitektur, Teknik Elektro, Teknik Mesin dan Teknologi Informasi\n"+
                        "Program Pasca Sarjana terdiri dari Teknik Arsitektur, Teknik Elektro, Teknik Sipil, Teknik Mesin dan S3 Ilmu Teknik ");

        LinkGambar.add("https://pbs.twimg.com/profile_images/509356570191208448/VTOwm2UU.jpeg");
        NamaFakultas.add("Fakultas Pertanian");
        NamaOrganisasiMahasiswa.add("BEMFP");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 3 Program Studi yaitu Agribisnis, Argeoteknologi, Arsitektur Pertamanan\n+" +
                "Program S2 terdiri dari Master Agribisnis, MAster Pertanian Lahan Kering dan Magister Bioteknologi Pertanian\n" +
                "Program S3 terdiri dari Doktor Ilmu Pertanian ");

        LinkGambar.add("https://sinmawa.unud.ac.id/img/admin/logo/3f1fc925e3c889e4679a72d20ea351ec.png");
        NamaFakultas.add("Fakultas Ekonomi dan Bisnis");
        NamaOrganisasiMahasiswa.add("BEM FEB");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Program Studi D3 Akuntansi, D3 Perpajakan\n" +
                "Program Studi S1 terdiri dari Ekonomi Pembangunan, Manajemen, Akuntansi\n" +
                "Program Studi S2 terdiri dari Magister Manajemen  (MM), Magister Ilmu Ekonomi, Magister Akuntansi\n" +
                "Program Studi S3  terdiri dari  Ilmu Ekonomi dan Ilmu Manajemen");

        LinkGambar.add("https://pbs.twimg.com/profile_images/686177774332035072/dnVFSRQA.jpg");
        NamaFakultas.add("Fakultas Petenakan");
        NamaOrganisasiMahasiswa.add("BEMKMFAPET");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari Program Studi S1 Peternakan, S2 Peternakan dan S3 Peternakan");

        LinkGambar.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZyYtCrT6Lp0WMmJS29RkwJeMlDRyzFhG1YhBoqVTDUdEbIRGiuA");
        NamaFakultas.add("Fakultas Matematika dan Ilmu Alam");
        NamaOrganisasiMahasiswa.add("BEMFMIPA");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 6 Program Studi yaitu Biologi, Kimia, Matematika, Fisika, Ilmu Komputer dan Farmasi");

        LinkGambar.add("http://4.bp.blogspot.com/-8gDYvIVThmo/UitTWbnDKlI/AAAAAAAAACc/XsKrzbgkixo/s1600/FKH+UNGU.png");
        NamaFakultas.add("Fakultas Kedokteran Hewan");
        NamaOrganisasiMahasiswa.add("BEMFKH");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari Program Studi yaitu Dokter Hewan");

        LinkGambar.add("https://pbs.twimg.com/profile_images/466373327800770561/WJ9_nPQ8.jpeg");
        NamaFakultas.add("Fakultas Teknologi Pertanian");
        NamaOrganisasiMahasiswa.add("BEMFTP");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 4 Program Studi yaitu S1 Teknik Pertanian, S1 Teknologi Industri, S1 Ilmu dan Teknologi Pangan, S2 Ilmu dan Teknologi Pangan");

        LinkGambar.add("https://pbs.twimg.com/profile_images/573778423954329601/dmZTlyTq_400x400.jpeg");
        NamaFakultas.add("Fakultas Pariwisata");
        NamaOrganisasiMahasiswa.add("BEMFPAR");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 3 Progrgam Studi yaitu D4 Pariwisata, S1 Destinasi Wisata, S1 Perjalanan Wisata");

        LinkGambar.add("https://pbs.twimg.com/profile_images/433786556529139712/muI68iqv.jpeg");
        NamaFakultas.add("Fakultas Ilmu Komunikasi dan Ilmu Politik");
        NamaOrganisasiMahasiswa.add("BEMFISIP");
        LokasiFakultas.add("Kampus Universitas Udayana Sudirman dan Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 6 Program Studi yaitu Sosiologi, D-3 Perpustakaan, Ilmu Politik, Ilmu Komunikasi, Administrasi Negara, Hubngan Internasional");

        LinkGambar.add("https://pbs.twimg.com/profile_images/3649801783/d29d71cfa3d702704b97a99db9356147_400x400.jpeg");
        NamaFakultas.add("Fakultas Kelautan dan Perikanan");
        NamaOrganisasiMahasiswa.add("BEMFKP");
        LokasiFakultas.add("Kampus  Universitas Udayana Jimbaran");
        DetailFakultas.add("Terdiri dari 2 Program Studi yaitu Ilmu kelautan dan Manajemen Sumber Daya Kelautan");

        showListActivity();

    }

    private void showListActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListActivity adapter = new ListActivity(this, NamaFakultas, LinkGambar, NamaOrganisasiMahasiswa, LokasiFakultas, DetailFakultas);
        recyclerView.setAdapter(adapter);
    }

    private void showCardViewActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardViewActivity adapter = new CardViewActivity(this, NamaFakultas, LinkGambar, NamaOrganisasiMahasiswa, LokasiFakultas, DetailFakultas);
        recyclerView.setAdapter(adapter);
    }

    private void showGridActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GridActivity adapter = new GridActivity(this,  NamaFakultas, LinkGambar, NamaOrganisasiMahasiswa,LokasiFakultas, DetailFakultas);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showListActivity();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showGridActivity();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showCardViewActivity();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putInt(STATE_MODE, mode);
    }
}