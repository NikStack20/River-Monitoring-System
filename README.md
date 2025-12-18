🌊 River Watch System

Real-Time Flood Monitoring with Location-Aware Intelligence

A full-stack monitoring system designed to track river water levels in real time, intelligently filter unreliable sensor data, and provide clear flood risk alerts through a live dashboard.

This project focuses on reliability, explainability, and system design, following industry-proven patterns instead of hype-driven complexity.

📌 Project Overview

Flood monitoring systems often fail due to:

Delayed alerts

Noisy or faulty sensor data

One-size-fits-all thresholds

River Watch System solves this by:

Continuously monitoring river levels

Filtering abnormal sensor spikes

Applying location-specific presets

Showing risk levels on a real-time dashboard

🧠 Key Features

📊 Real-time river level graph

🚦 Risk classification: SAFE / WARNING / DANGER

🧩 Location-aware presets (same logic, different behavior)

🧠 Explainable intelligence (no black-box AI)

🔄 Mock sensor simulation for testing

🌐 Frontend + Backend decoupled architecture

🏗️ System Architecture

Mock Sensor Data
      ↓
Spring Boot Backend
      ↓
Business Logic + Presets
      ↓
Database (Time-Series Data)
      ↓
REST APIs
      ↓
React Frontend Dashboard

🧰 Tech Stack
Backend

Java 17

Spring Boot

Spring Data JPA

Scheduler (Mock Sensor)

Configuration-based presets (YAML)

REST APIs

Frontend

React

Chart.js

Axios

Polling-based real-time updates

📁 Project Structure

River-Monitoring-System/
│
├── River-Watch-Backend/
│   ├── src/main/java/
│   │   ├── config/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── model/
│   │   ├── repository/
│   │   └── scheduler/
│   │
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   └── presets.yml
│   │
│   ├── react-frontend/   ← Frontend inside backend folder
│   │
│   └── pom.xml
│
└── README.md


⚙️ Location Preset Concept

Different rivers behave differently.

Instead of retraining models:

We use preset-based configuration

Each location has its own thresholds and sensitivity

Example:

locations:
  mountain_river:
    maxJump: 0.3
    windowSize: 3
    warningLevel: 5.5
    dangerLevel: 7.0


▶️ How to Run the Project (Local)
1️⃣ Clone Repository

git clone https://github.com/NikStack20/River-Monitoring-System.git
cd River-Monitoring-System/River-Watch-Backend

2️⃣ Run Backend (Spring Boot)

mvn spring-boot:run

http://localhost:9999

http://localhost:9999/actuator/health

3️⃣ Run Frontend (React)

cd react-frontend
npm install
npm start

Frontend will start on:

http://localhost:3000


📡 API Endpoints
 Endpoint	               Description
/api/river/levels	       Latest river level readings
/api/river/status	       Current risk level & confidence
/actuator/health	       Backend health check

🧪 Testing & Validation

Simulated sensor data generation

Spike detection (fake sensor errors)

Preset switching between locations

Backend ↔ frontend integration testing

Real-time UI updates via polling

💡 Why This Approach?

✔ Easy to explain and maintain

✔ Reliable under noisy real-world data

✔ Scalable to new locations

✔ Industry-aligned system design

✔ Avoids unnecessary heavy AI models

🚀 Future Scope

Integration with real IoT river sensors

Weather & rainfall API integration

SMS / Mobile alerts for authorities

Advanced ML models if required

Cloud-scale deployment

🧑‍🎓 Learning Outcomes

Backend system design with Spring Boot

Configuration-driven intelligence

Real-time frontend dashboards

Full-stack integration

Industry-style debugging & deployment workflow

👤 Author

nikStack
B.Tech Undergraduate
Backend & System Design Enthusiast

GitHub:
👉 https://github.com/NikStack20


