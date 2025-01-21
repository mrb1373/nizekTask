# NizekTask
This repository contains the **NizekTask** project, designed as part of a technical interview task. It demonstrates best practices in Android development with a focus on clean architecture and modular design.

## Features

- **Modular Architecture**: Organized into logical modules for scalability.
- **MVVM Architecture**: Implements the Model-View-ViewModel pattern for separation of concerns.
- **Kotlin**: Codebase fully written in Kotlin for modern Android development.

## Screen shots
<div style="display: flex; gap: 10px;">
  <img src="nizek.png" alt="Product Search" width="300"/>
</div>

## Project Structure

- **`app`**: Contains the main application logic and entry point.
- **`core`**: Includes submodules ( network, data, common ).
- **`feature`**: Module to manage each application feature separately, each feature comes as a separate submodule
- **`build-logic`**: Module for sharing the dependencies through plugins, it can improve app scalability

### Prerequisites
- Android Studio (latest version recommended)
- Kotlin 1.5+ and Gradle 7.0+

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/mrb1373/nizekTask.git