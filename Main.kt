fun main() {
    val filmulDune = Film("Dune: Part Two", 166)
    val biletulMeu = Bilet(filmulDune, "Rand 5, Loc 12", 45.0)

    val manager = ManagerBooking()

    println("Plata cash: ")
    val plataCash=PlataCash(100.0)
    manager.procesare(biletulMeu, plataCash)

    println("\nPlata cu cardul: ")
    val contulMeu=ContBanca(200.0, "1234-5678-9012", "Serban Amariei-Hondrea")
    val plataCard=PlataCard(contulMeu)
    manager.procesare(biletulMeu, plataCard)

    if(contulMeu.sumaDisponibila>=0)
    {
        println("\nSuma ramasa în cont: ${contulMeu.sumaDisponibila} RON")
    }
    else
    {
        println("\nDaca iesi in parc iti arunca porumbeii seminte")
    }
}