

package com.mycompany.moviemanager;
import java.util.ArrayList;
import java.util.Scanner;

class Movie {
String name;
String category;
double rating;

Movie(String name, String category, double rating) {
this.name = name;
this.category = category;
this.rating = rating;
}

void display() {
System.out.println("Name: " + name + " | Category: " + category + " | Rating: " + rating);
}
}

public class MovieManager {

static ArrayList<Movie> movies = new ArrayList<>();
static Scanner input = new Scanner(System.in);

public static void main(String[] args) {
int choice;

do {
System.out.println("\n=== Movie Management System ===");
System.out.println("1. Add Movie");
System.out.println("2. Update Movie");
System.out.println("3. Delete Movie");
System.out.println("4. View All Movies");
System.out.println("5. Search by Name");
System.out.println("6. Search by Category");
System.out.println("7. Search by Rating Range");
System.out.println("0. Exit");

System.out.print("Choose: ");
choice = input.nextInt();
input.nextLine();

switch (choice) {
case 1 -> addMovie();
case 2 -> updateMovie();
case 3 -> deleteMovie();
case 4 -> viewMovies();
case 5 -> searchByName();
case 6 -> searchByCategory();
case 7 -> searchByRating();
}

} while (choice != 0);
}

//  Add Movie
static void addMovie() {
System.out.print("Enter movie name: ");
String name = input.nextLine();

System.out.print("Enter category: ");
String category = input.nextLine();

System.out.print("Enter rating: ");
double rating = input.nextDouble();
input.nextLine();

movies.add(new Movie(name, category, rating));
System.out.println("✅ Movie added!");
}

// ️ Update Movie
static void updateMovie() {
System.out.print("Enter movie name to update: ");
String name = input.nextLine();

for (Movie m : movies) {
if (m.name.equalsIgnoreCase(name)) {
System.out.print("New name: ");
m.name = input.nextLine();

System.out.print("New category: ");
m.category = input.nextLine();

System.out.print("New rating: ");
m.rating = input.nextDouble();
input.nextLine();

System.out.println("✅ Movie updated!");
return;
}
}
System.out.println("❌ Movie not found!");
}

//  Delete Movie
static void deleteMovie() {
System.out.print("Enter movie name to delete: ");
String name = input.nextLine();

for (Movie m : movies) {
if (m.name.equalsIgnoreCase(name)) {
movies.remove(m);
System.out.println("✅ Movie deleted!");
return;
}
}
System.out.println("❌ Movie not found!");
}

// ? View All
static void viewMovies() {
if (movies.isEmpty()) {
System.out.println("No movies available.");
return;
}

for (Movie m : movies) {
m.display();
}
}

//  Search by Name
static void searchByName() {
System.out.print("Enter name: ");
String name = input.nextLine();

for (Movie m : movies) {
if (m.name.equalsIgnoreCase(name)) {
m.display();
return;
}
}
System.out.println("❌ Movie not found!");
}

// Search by Category
static void searchByCategory() {
System.out.print("Enter category: ");
String category = input.nextLine();

for (Movie m : movies) {
if (m.category.equalsIgnoreCase(category)) {
m.display();
}
}
}

// Search by Rating Range
static void searchByRating() {
System.out.print("Enter min rating: ");
double min = input.nextDouble();

System.out.print("Enter max rating: ");
double max = input.nextDouble();
input.nextLine();

for (Movie m : movies) {
if (m.rating >= min && m.rating <= max) {
m.display();
}
}
}
}

