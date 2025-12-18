# 🌊 River Watch System  
## Real-Time Flood Monitoring with Location-Aware Intelligence

A **full-stack monitoring system** designed to track river water levels in real time, intelligently filter unreliable sensor data, and provide clear flood risk alerts through a live dashboard.

This project focuses on **reliability, explainability, and system design**, following industry-proven patterns instead of hype-driven complexity.

---

## 📌 Project Overview

Flood monitoring systems often fail due to:

- Delayed alerts  
- Noisy or faulty sensor data  
- One-size-fits-all thresholds  

**River Watch System** addresses these challenges by:

- Continuously monitoring river water levels  
- Filtering abnormal or faulty sensor spikes  
- Applying location-specific preset configurations  
- Displaying clear risk levels on a real-time dashboard  

---

## 🧠 Key Features

- 📊 **Real-time river level visualization**
- 🚦 **Risk classification**: SAFE / WARNING / DANGER
- 🧩 **Location-aware presets** (same logic, different behavior)
- 🧠 **Explainable intelligence** (rule-based + lightweight analysis)
- 🔄 **Mock sensor simulation** for controlled testing
- 🌐 **Decoupled frontend and backend architecture**

---

## 🏗️ System Architecture

Mock / Simulated Sensor Data
↓
Spring Boot Backend
↓
Business Logic + Preset Engine
↓
Database (Time-Series Storage)
↓
REST APIs
↓
React Frontend Dashboard



---

## 🧰 Tech Stack

### Backend
- Java 17  
- Spring Boot  
- Spring Data JPA  
- Scheduled mock sensor generator  
- YAML-based configuration presets  
- RESTful APIs  

### Frontend
- React  
- Chart.js  
- Axios  
- Polling-based real-time updates  

---

## 📁 Project Structure

River-Monitoring-System/
│
├── River-Watch-Backend/
│ ├── src/main/java/
│ │ ├── config/ # Presets, CORS, application configs
│ │ ├── controller/ # REST controllers
│ │ ├── service/ # Core business logic
│ │ ├── model/ # Domain models
│ │ ├── repository/ # JPA repositories
│ │ └── scheduler/ # Mock sensor generator
│ │
│ ├── src/main/resources/
│ │ ├── application.yml
│ │ └── presets.yml
│ │
│ ├── react-frontend/ # React frontend (inside backend folder)
│ │
│ └── pom.xml
│
└── README.md




---

## ⚙️ Location Preset Concept

Different rivers behave differently based on geography and flow patterns.

Instead of retraining models for each river, the system uses
**preset-based configuration**:

- Each location has predefined thresholds
- Core decision logic remains unchanged
- Behavior is controlled entirely via configuration files

### Example Preset Configuration

```yaml
locations:
  mountain_river:
    maxJump: 0.3
    windowSize: 3
    warningLevel: 5.5
    dangerLevel: 7.0


## ▶️ How to Run the Project (Local Setup)
1️⃣ Clone the Repository

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
http://localhost:3000

## 📡 API Endpoints

Endpoint          	Description
/api/river/levels 	Fetch recent river level readings
/api/river/status	      Current risk status with confidence
/actuator/health       	Backend health status


## 🧪 Testing & Validation Strategy

Mock sensor data generation for controlled testing

Spike detection to ignore faulty sensor readings

Location preset switching validation

Backend ↔ frontend integration testing

Real-time UI update verification via polling


## 💡 Why This Approach?

✔ Simple and explainable system design

✔ Reliable under noisy real-world data

✔ Easily scalable to multiple locations

✔ Aligns with industry backend practices

✔ Avoids unnecessary heavy AI models


## 🚀 Future Scope

Integration with real IoT-based river sensors

Weather and rainfall data integration

Automated alert notifications

Advanced predictive models if required

Cloud-based deployment for scalability


## 🧑‍🎓 Learning Outcomes

Backend system design using Spring Boot

Configuration-driven decision systems

Real-time frontend dashboards

End-to-end full-stack integration

Industry-style debugging and deployment workflow


## 👤 Author

nikStack
B.Tech Undergraduate
Backend & System Design Enthusiast

## 🔗 GitHub:
https://github.com/NikStack20






