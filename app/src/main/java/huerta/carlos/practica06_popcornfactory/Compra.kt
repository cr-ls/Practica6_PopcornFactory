package huerta.carlos.practica06_popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ConfirmacionCompra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra)

        val bundle = intent.extras

        val imgPelicula: ImageView = findViewById(R.id.imgPelicula) as ImageView
        val txtTitle: TextView = findViewById(R.id.titlePelicula) as TextView
        val btnConfirm: Button = findViewById(R.id.btnConfirm) as Button
        val txtasiento: TextView = findViewById(R.id.asiento) as TextView

        txtTitle.setText(bundle?.getString("name"))
        txtasiento.setText(bundle?.getString("asiento"))
        imgPelicula.setImageResource(bundle!!.getInt("header"))

        btnConfirm.setOnClickListener {
            Toast.makeText(this,"enjoy the movie", Toast.LENGTH_LONG).show()
            var intent = Intent(this, SeatSelection::class.java)
            intent.putExtra("posConfirm", bundle!!.getInt("asiento"))
            this.startActivity(intent)
        }
    }
}