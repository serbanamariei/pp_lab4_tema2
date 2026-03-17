interface MetodaPlata
{
    fun pay(plata: Double): Boolean
}

class ContBanca(
    var sumaDisponibila: Double,
    val nrCard: String,
    val owner: String
)
{
    fun updateSuma(valoare: Double): Boolean
    {
        if(valoare<0 && sumaDisponibila<-valoare)
        {
            return false
        }
        sumaDisponibila+=valoare
        return true
    }
}

class Film(
    val titlu: String,
    val durataMin: Int
)

class Bilet(
    val film: Film,
    val loc: String,
    val pret: Double
)

class PlataCash (
    private var sumaDisponibila: Double
): MetodaPlata
{
    public override fun pay(plata: Double): Boolean
    {
        if(sumaDisponibila>=plata)
        {
            sumaDisponibila-=plata
            return true
        }
        return false
    }
}

class PlataCard(
    private var acc: ContBanca
) : MetodaPlata
{
    override fun pay(plata: Double): Boolean
    {
        return acc.updateSuma(-plata)
    }
}

class ManagerBooking
{
    fun procesare(bilet: Bilet, plata: MetodaPlata)
    {
        if(plata.pay(bilet.pret))
        {
            println("Plata s a executat cu succes!!!")
        }
        else
        {
            println("Plata ESUATA!!!")
        }
    }
}