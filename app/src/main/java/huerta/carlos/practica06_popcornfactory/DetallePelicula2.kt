package huerta.carlos.practica06_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula2.*


class DetallePelicula2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula2)

        val bundle = intent.extras
        var ns = 0;
        var id = -1;
        var title = "";

        if (bundle != null) {
            var ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre.setText(bundle.getString("Nombre"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available ")
            id = bundle.getInt("pos")
        }

        if (ns==0){
            BuyTickets.isEnabled = false
        } else
            BuyTickets.isEnabled = false
            BuyTickets.setOnClickListener{
            val intent: Intent = Intent(this, SeatSelection::class.java)

            intent.putExtra("id", id)
            intent.putExtra("name", title)
            this.startActivity(intent)
        }
    }
}