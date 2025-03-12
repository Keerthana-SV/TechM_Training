import 'package:flutter/material.dart';
import '../models/movie.dart';

class BookingScreen extends StatefulWidget {
  final Movie movie;

  BookingScreen({required this.movie});

  @override
  _BookingScreenState createState() => _BookingScreenState();
}

class _BookingScreenState extends State<BookingScreen> {
  DateTime selectedDate = DateTime.now();
  String selectedTime = "12:00 PM";
  int selectedSeats = 1;

  List<String> timeSlots = ["10:00 AM", "12:00 PM", "3:00 PM", "6:00 PM", "9:00 PM"];

  Future<void> _selectDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: selectedDate,
      firstDate: DateTime.now(),
      lastDate: DateTime.now().add(Duration(days: 30)),
    );
    if (picked != null && picked != selectedDate) {
      setState(() {
        selectedDate = picked;
      });
    }
  }

  void _confirmBooking() {
    ScaffoldMessenger.of(context).showSnackBar(
      SnackBar(content: Text("Booking confirmed for ${widget.movie.title}!")),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Book Movie - ${widget.movie.title}")),
      body: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Center(
              child: Image.network(widget.movie.poster, height: 150, fit: BoxFit.cover),
            ),
            SizedBox(height: 20),
            Text("Select Date", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
            SizedBox(height: 5),
            Row(
              children: [
                Text("${selectedDate.toLocal()}".split(' ')[0], style: TextStyle(fontSize: 16)),
                IconButton(
                  icon: Icon(Icons.calendar_today),
                  onPressed: () => _selectDate(context),
                ),
              ],
            ),
            SizedBox(height: 10),
            Text("Select Time", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
            SizedBox(height: 5),
            DropdownButton<String>(
              value: selectedTime,
              onChanged: (String? newValue) {
                setState(() {
                  selectedTime = newValue!;
                });
              },
              items: timeSlots.map<DropdownMenuItem<String>>((String time) {
                return DropdownMenuItem<String>(
                  value: time,
                  child: Text(time),
                );
              }).toList(),
            ),
            SizedBox(height: 10),
            Text("Select Seats", style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold)),
            SizedBox(height: 5),
            Row(
              children: [
                IconButton(
                  icon: Icon(Icons.remove),
                  onPressed: selectedSeats > 1 ? () => setState(() => selectedSeats--) : null,
                ),
                Text("$selectedSeats", style: TextStyle(fontSize: 16)),
                IconButton(
                  icon: Icon(Icons.add),
                  onPressed: () => setState(() => selectedSeats++),
                ),
              ],
            ),
            SizedBox(height: 20),
            Center(
              child: ElevatedButton(
                onPressed: _confirmBooking,
                child: Text("Confirm Booking"),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
