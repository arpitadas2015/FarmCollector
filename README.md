Endpoints:
•	POST /api/planting to add planting data.
•	GET /api/planting to get planting data.
•	POST /api/harvesting to add harvesting data.
•	GET /api/harvesting to get harvesting data.
•	GET /api/report to generate reports.

Sample Requests:
Adding planting data:
curl -X POST "http://localhost:8080/api/planting" -H "Content-Type: application/json" -d '{"farmName": "MyFarm", "season": "Spring", "cropType": "Corn", "plantingArea": 100, "expectedProduct": 150}'

Adding harvesting data:
curl -X POST "http://localhost:8080/api/harvesting" -H "Content-Type: application/json" -d '{"farmName": "MyFarm", "season": "Spring", "cropType": "Corn", "actualProduct": 140}'

Generating a report:
curl -X GET http://localhost:8080/api/report?season=Spring




