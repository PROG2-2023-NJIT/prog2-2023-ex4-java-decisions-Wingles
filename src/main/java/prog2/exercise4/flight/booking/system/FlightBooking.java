package prog2.exercise4.flight.booking.system;


import java.time.LocalDate;
import java.time.Period;
import java.util.Random;


public class FlightBooking {
    enum BookingClass{FIRST,BUSINESS,ECONOMY }
    enum TripType{ONE_WAY,RETURN}
    enum TripSource{BEIJING, SHANGHAI, OULU, NANJING, PARIS,HELSINKI}
    enum TripDestination{BEIJING, SHANGHAI, OULU, NANJING, PARIS,HELSINKI}
    enum SourceAirport{NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,
                       SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT,
                       PARIS_CHARLES_DE_GAULLE_AIRPORT}
    enum Destinationairport{NANJING_LUKOU_INTERNATIONAL_AIRPORT, BEIJING_CAPITAL_INTERNATIONAL_AIRPORT,
                            SHANGHAI_PUDONG_INTERNATIONAL_AIRPORT, OULU_AIRPORT, HELSINKI_AIRPORT,
                            PARIS_CHARLES_DE_GAULLE_AIRPORT}
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;
    private double totalTicketPrice;
    private String passengerFullName;
    private String flightID;
    private String ticketNumber;
    private String classification;
    private final String flightCompany = "Flights-of-Fancy";
    private TripSource tripSource ;
    private SourceAirport sourceAirport ;
    private TripDestination tripDestination;
    private Destinationairport destinationAirport;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private BookingClass bookingClass;
    private TripType tripType;
    private Destinationairport destinationairport;
    boolean TF=false;


    public FlightBooking (String passengerFullName,LocalDate departureDate,LocalDate returnDate,int childPassengers,int adultPassengers){
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
        setTotalPassengers( childPassengers, adultPassengers);
    }
    public BookingClass getBookingClass(){
        return bookingClass;
    }
    public void setBookingClass(String bookingClass){
        switch (bookingClass){
            case "1":
                this.bookingClass = BookingClass.FIRST;
                break;
            case "2":
                this.bookingClass = BookingClass.BUSINESS;
                break;
            case "3":
                this.bookingClass = BookingClass.ECONOMY;
                break;
            default:
                System.out.println("Error");
                break;
        }

    }
    public void setTripType(String tripType){
        switch (tripType) {
            case "1":
                this.tripType = TripType.ONE_WAY;
                break;
            case "2":
                this.tripType = TripType.RETURN;
                break;
            default:
                System.out.println("Error");
        }
    }

    public void setTripSource(String tripSource)
    {
        switch (tripSource){
            case "1":
                this.tripSource = TripSource.NANJING;
                this.sourceAirport = SourceAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
            case "2":
                this.tripSource = TripSource.BEIJING;
                this.sourceAirport = SourceAirport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case "3":
                this.tripSource = TripSource.OULU;
                this.sourceAirport = SourceAirport.OULU_AIRPORT;
                return;
            case "4":
                this.tripSource = TripSource.HELSINKI;
                this.sourceAirport = SourceAirport.HELSINKI_AIRPORT;
                break;
            default:
                System.out.println("Error");
        }
    }

    public void setDepartingTicketPrice(int childPassengers,int adultPassengers)
    {
        setClassification(tripSource.toString(),tripDestination.toString());
        switch (bookingClass) {
            case FIRST:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers+adultPassengers) *345 +250;
                else
                    this.departingTicketPrice = (childPassengers+adultPassengers) *375 +250;
                break;
            case BUSINESS:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers+adultPassengers) *345 +150;
                else
                    this.departingTicketPrice = (childPassengers+adultPassengers) *375 +150;
                break;
            case ECONOMY:
                if (classification.equals("domestic"))
                    this.departingTicketPrice = (childPassengers+adultPassengers) *345 +50;
                else
                    this.departingTicketPrice = (childPassengers+adultPassengers) *375 +50;
            default:
                break;
        }

    }

    public void setClassification(String _source,String _destination)
    {
      String x = _source +  _destination;
      if (x.equals("NANJINGBEIJING")||x.equals("BEIJINGNANJING")||x.equals("OULUHELSINKI")||x.equals("HELSINKIOULU"))
      {
         this.classification = "domestic";
      }
      else
          this.classification = "international";
    }
    public void setTripDestination(String tripSource,String tripDestination)
    {
        switch (tripDestination){
            case "1":
                this.tripDestination = TripDestination.NANJING;
                this.destinationairport = Destinationairport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
                break;
            case "2":
                this.tripDestination = TripDestination.BEIJING;
                this.destinationairport = Destinationairport.BEIJING_CAPITAL_INTERNATIONAL_AIRPORT;
                break;
            case "3":
                this.tripDestination = TripDestination.OULU;
                this.destinationairport = Destinationairport.OULU_AIRPORT;
                break;
            case "4":
                this.tripDestination = TripDestination.HELSINKI;
                this.destinationairport = Destinationairport.HELSINKI_AIRPORT;
                break;
            default:
                System.out.println("Error");
        }
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate){
        this.returnDate = returnDate;
            Period p = Period.between(departureDate,returnDate);
            if (p.getDays() < 2 && p.getMonths() <=0 &&p.getYears()<=0) {
                this.returnDate = departureDate.plusDays(2);
                this.TF = true;
            } else
                this.returnDate = returnDate;

    }

    public String getFlightCompany()
    {
        return flightCompany;
    }
    public TripSource getTripSource()
    {
        return tripSource;
    }
    public TripDestination getTripDestination()
    {
        return tripDestination;
    }

    public String getPassengerFullName()
    {
        return passengerFullName;
    }

    public LocalDate getDepartureDate(){
        return departureDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }


    public int getChildPassengers(){
        return childPassengers;
    }

    public int getAdultPassengers(){
        return adultPassengers;
    }

    public int getTotalPassengers()
    {
        return totalPassengers;
    }
    public void setTotalPassengers(int childPassengers,int adultPassengers){
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public double getDepartingTicketPrice()
    {
        return departingTicketPrice;
    }

    public double getReturnTicketPrice()
    {
        return returnTicketPrice;
    }
    public void setReturnTicketPrice(){
        switch (tripType){
            case ONE_WAY:
                this.returnTicketPrice = 0;
                break;
            case RETURN:
                this.returnTicketPrice = departingTicketPrice;
                break;
            default:
                break;
        }
    }
    public double getTotalTicketPrice()
    {
        return totalTicketPrice;
    }
    public void setTotalTicketPrice(){
        this.totalTicketPrice = departingTicketPrice + returnTicketPrice;
    }
    public String getTicketNumber()
    {
        setTicketNumber();
        return ticketNumber;
    }
    public void setTicketNumber()
    {   setClassification(tripSource.toString(),tripDestination.toString());
        Random rnd = new Random();
        int number = rnd.nextInt(9000)+1000;
        String m = String.valueOf(number);
        switch (bookingClass){
            case FIRST:
                if (tripType.equals(TripType.ONE_WAY))
                {
                    if (classification.equals("domestic"))
                        this.ticketNumber = "11" + "F" + m + "DOM";
                    else
                        this.ticketNumber = "11" + "F" + m + "INT";
                }
                else{
                    if (classification.equals("domestic"))
                        this.ticketNumber = "22" + "F" + m + "DOM";
                    else
                        this.ticketNumber = "22" + "F" + m + "INT";
                }
                break;
            case BUSINESS:
                if (tripType.equals(TripType.ONE_WAY))
                {
                    if (classification.equals("international"))
                        this.ticketNumber = "11" + "B" + m + "DOM";
                    else
                        this.ticketNumber = "11" + "B" + m + "INT";
                }
                else{
                    if (classification.equals("domestic"))
                        this.ticketNumber = "22" + "B" + m + "DOM";
                    else
                        this.ticketNumber = "22" + "B" + m + "INT";
                }
                break;
            case ECONOMY:
                if (tripType.equals(TripType.ONE_WAY))
                {
                    if (classification.equals("international"))
                        this.ticketNumber = "11" + "E" + m + "DOM";
                    else
                        this.ticketNumber = "11" + "E" + m + "INT";
                }
                else{
                    if (classification.equals("domestic"))
                        this.ticketNumber = "22" + "E" + m + "DOM";
                    else
                        this.ticketNumber = "22" + "E" + m + "INT";
                }
                break;
            default:
                break;
        }
    }
    public String toString()
    {   setDepartingTicketPrice( childPassengers, adultPassengers);
        setReturnTicketPrice();
        setTotalTicketPrice();
        setTicketNumber();
        setDepartureDate(departureDate);
        setReturnDate(returnDate);
        String T = "Thank you for booking your flight with "+ flightCompany+". Following are the details \nof your booking and the trip: \n\nTicket Number:"
                +ticketNumber+"\nPassenger Name: "+ passengerFullName+"\nFrom " +tripSource+ " to "+tripDestination +"\nDate of departure: "+departureDate+"\nDate of return: "+returnDate+"(Changed from old returningDate to new returningDate)\nTotal passengers:"+
                totalPassengers+"\nTotal ticket price in Euros: "+totalTicketPrice;

        String F = "Thank you for booking your flight with "+ flightCompany+". Following are the details \nof your booking and the trip: \n\nTicket Number:"
                +ticketNumber+"\nFrom " +tripSource+ " to "+tripDestination +"\nDate of departure: "+departureDate+"\nDate of return: "+returnDate+"(Changed from old returningDate to new returningDate)\nTotal passengers:"+
                totalPassengers+"\nTotal ticket price in Euros: "+totalTicketPrice+"\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was \n" +
                "less than two days apart from your departure date.";
        if (TF)
        {
            return F;
        }

            return T;

    }



}
