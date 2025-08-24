# 01-fullstack-vendor-onboarding
# Trusted Vendors Portal – Full-Stack Assignment

## Objective
Welcome to your application assessment assignment. This is a chance for you to show us your coding and problem solving skills.
You are applying for a fullstack position so this assignment requires you to solve both frontend and backend challenges.

Nobody expects anyone to know everything so if a particular assignment is outside of your realm of experience, 
you may either skip it or propose a solution aligned with your experience.. 

In this repository, you'll find a basic demo implementation of the **Trusted Vendor Portal** application. 
Your task is to enhance and deploy this application by completing specific requirements listed below.

The system currently allows users to:
- Register a vendor (name, contact person, email, partner type [Supplier/Partner])
- View a list of registered vendors

---
## Vendor Object Example
    {
      "id": "1",
      "name": "Acme Freight",
      "contact_person": "John Doe",
      "email": "john.doe@acme.com",
      "partner_type": "Supplier" 
    }

## Existing Implementation

The repository contains:
- A Vue.js frontend application
- Two backend implementations (choose one):
  - Java (Spring Boot)
  - Node.js (TypeScript)

## Available Backends
You may choose which backend implementation to work with:

### Java (Spring Boot)
- Located in the `backend-java` directory
- Uses H2 in-memory database
- Includes basic create and list operations

### Node.js (TypeScript)
- Located in the `backend-node` directory 
- Uses SQLite database
- Includes basic create and list operations
---
## Your Tasks

### 1. Delete vendor
- Implement a delete functionality to allow users to remove vendor entries from the system
- Include a confirmation dialog before deletion to prevent accidental removal.
- Update both frontend and your chosen backend to support this feature

### 2. Fix the UI bug
- Currently, clicking the "Add" button multiple times before the form resets can result in duplicate vendor entries.
- Prevent this behavior to improve the form UX

### 3. Unique Emails
- Ensure that vendor emails are unique across the system. If a user tries to register a vendor with a duplicate email, they should be informed of the conflict. 
  Think about where this logic should live and how the constraint is best enforced (frontend, backend, data storage or all) and justify your approach
- Document your reasoning

### 4. Containerization & Deployment (Optional)
At maerks we host most of our backend services using pods and k8. If you have experience or find the challenge interesting, give this assignment a go.

Choose one of the following deployment approaches:

#### Option A: Docker Compose
- Containerize your chosen backend using Docker
- Create a Docker Compose configuration to run the entire system (frontend + backend)
- Include clear instructions to build and start the application

#### Option B (Advanced): Kubernetes/Minikube Deployment
- Create Kubernetes manifests (YAML files) for both frontend and your chosen backend
- Ensure services can discover and communicate (e.g., using `ClusterIP`)
- Use **Minikube** to test locally
- Provide clear documentation or scripts to:
  - Build and push Docker images to Minikube's Docker daemon
  - Apply Kubernetes configs to start the app

You're welcome to make UX improvements or add minor enhancements, as long as the core requirements are clearly addressed.

---

## Evaluation Criteria
- **Code clarity & organisation** – Is the code readable, modular, testable and well-structured?
- **Testing** - How did you use testing to support your development efforts
- **Full-stack ownership** – Can you deliver a cohesive, working system with the required enhancements?
- **Pragmatism** – Did you make thoughtful decisions and sensible trade-offs?
- **DevOps awareness** – Is the system easy to build, run, and maintain?
- **Deployment quality** – If completed, is your containerization strategy practical, reproducible, and well-documented?"

---

## Submission Instructions

1. **Copy** this repository into your own GitHub account.
2. Complete the assigned tasks in copy.
3. **Documentation**
    1. Ensure your repository includes setup instructions and an updated README.md.
    2. Provide a short description of your approach to solving each task
    3. Highlight any assumptions, trade-offs, or challenges encountered during development.
4. In your readme.md file, also answer the following questions:
    1. What do I love most about being a software engineer.
    2. What is most important to me when it comes to working in a team
    3. What is the worst part of being a software engineer.
4. Share the link to your repository with us.
---

**DOCUMENTATION** (24-08-2025)
## Setup Instructions

1. Clone the repository:
   a-Through VS code terminal-
   git clone https://github.com/maersk-recruitment-tasks/01-fullstack-vendor-onboarding
   cd vendor-onboarding-app
   b- Install frontend dependencies- npm install
   c- Install backend dependencies-mvn clean install
   d- run spring-bot application- mvn spring-boot:run
   e- ensured whether BE is running with - http://localhost:3001/api/vendors
   f- run fron end now- npm run dev
   g- verified if its running- http://localhost:5173/

2- Tasks Approach-
    a- **Delete vendor**
    -Added DELETE and logic in method by passing the vendor id reference endpoint in vendorController
    -create deleteVendor logic in FE vendorService.ts to call the delete api
    -handled the deletion in vendorList by triggering the deletion and refreshing the list again.
    -binded the delete action with button.

   b- **Fix the UI bug**
-Prevented rapid clicks by disabling the "Add vendor" button while the request is in progress.
-in vendorStore.ts , defined loading property as false making it true once we get the value.

c- **Unique Emails**
-Added UNIQUE constraint in data.sql in ALTER TABLE query
-ceking if the email already exists from vendor repo
-handling exception properly by creating seperate file and checking in UI component if error is 409, already exits then throwing a messaged in UI.

3-Assumptions & Trade-offs or challenges encountered during development.

- Assumed backend returns plain text error messages (e.g. "Email already exists") instead of structured JSON.
- 
- Chose to keep error handling simple and readable rather than introducing a global error handler.
- 
- Used basic form validation and error display to keep the UI minimal and focused.
- 
- faced challenge in refreshing the list after deleting the vendor but it was still showing in the UI so reference handle carefully.
- 
- Also for unique email BE response is plain text not json format so struck there for some time due to parsing the value improperly to through the error message.

4
-What do I love most about being a software engineer- 

Solving real-world problems with clean, scalable code and Obviously for continuous learning. Tech evolves fast, and being a software engineer means you're always growing — learning new frameworks, debugging new challenges, and refining your thinking. It’s a career that keeps your mind sharp and your curiosity alive.

-What is most important to me when it comes to working in a team-

Clear communication, Mutual respect and Shared ownership.

-What is the worst part of being a software engineer-

intermittent bugs, Environment-specific issues and worst is Burnout risk
    
We're excited to see how you approach these tasks — feel free to get creative, make reasonable trade-offs, and show us how you think as an engineer. We're particularly interested in your understanding of full-stack development and DevOps practices.
