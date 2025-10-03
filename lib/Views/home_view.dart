import 'package:flutter/material.dart';
import 'login_view.dart';

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  int _currentIndex = 0;

  final List<Widget> _screens = [
    const Center(child: Text("Inicio 🏠", style: TextStyle(fontSize: 22))),
    const Center(child: Text("Buscar 🔍", style: TextStyle(fontSize: 22))),
    const Center(child: Text("Perfil 👤", style: TextStyle(fontSize: 22))),
    const RegistrationForm(), // 👈 Nueva pantalla de Login
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("APPParents")),
      body: _screens[_currentIndex],
      bottomNavigationBar: BottomNavigationBar(
        backgroundColor: Colors.white, // 👈 Fondo blanco
        selectedItemColor: const Color.fromARGB(
          255,
          24,
          24,
          24,
        ), // Color del ítem activo
        unselectedItemColor: Colors.grey, // Ítems inactivos
        currentIndex: _currentIndex,
        onTap: (index) {
          setState(() {
            _currentIndex = index;
          });
        },
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "Inicio"),
          BottomNavigationBarItem(icon: Icon(Icons.search), label: "Buscar"),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: "Perfil"),
          BottomNavigationBarItem(icon: Icon(Icons.login), label: "Register"),
        ],
      ),
    );
  }
}
