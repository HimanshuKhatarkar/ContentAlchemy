# Project Repository Structure


    ContentAlchemy/
    |-- .gitignore                // Git ignore file
    |-- README.md                 // Project documentation
    |-- frontend/                 // Frontend code
    |   |-- public/               // Public assets
    |   |-- src/                  // Source code
    |   |   |-- assets/           // Frontend assets (images, styles, etc.)
    |   |   |-- components/        // React/Vue/Angular components
    |   |   |-- services/          // Frontend services (API calls, utilities)
    |   |   |-- App.vue/index.js   // Main frontend entry points
    |-- backend/                  // Backend code (Spring Boot)
    |   |-- src/                  // Source code
    |   |   |-- main/             // Main application code
    |   |   |   |-- java/         // Java source code
    |   |   |   |   |-- com/
    |   |   |   |   |   |-- contentalchemy/
    |   |   |   |   |   |   |-- controllers/    // REST controllers
    |   |   |   |   |   |   |-- models/         // Data models
    |   |   |   |   |   |   |-- repositories/   // Database repositories
    |   |   |   |   |   |   |-- services/       // Backend services
    |   |   |   |-- resources/     // Application configuration files
    |-- database/                 // Database related files
    |   |-- scripts/              // Database initialization scripts
    |-- .env                      // Environment variable configuration (if needed)
    |-- docker-compose.yml        // Docker Compose file for containerization

# Project Naming Nomenclature
1.Frontend: For frontend components and files, camelCase or kebab-case convention for naming Depending on Language:

    ContentUploader.js (CamelCase for JavaScript/React files)
    content-uploader.css (Kebab-case for CSS files)
    userProfile.vue (CamelCase for Vue.js single-file components)


2. Backend:
    ContentController.java (CamelCase for Java classes)
    content_controller.py (Snake_case for Python files/classes)
    UserController.ts (CamelCase for TypeScript files)


3. Database: lowercase letters and underscores.

    user_profiles
    content_videos
    editor_assignments


4. Routes: 
    /api/upload (for content upload)
    /api/edit (for video editing)
    /api/review (for content review)
