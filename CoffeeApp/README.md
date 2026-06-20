# ☕ Coffee App - Modern Jetpack Compose UI

A beautifully designed, responsive Coffee Application built entirely with **Jetpack Compose**. This project demonstrates modern Android development practices, interactive UI components, and seamless navigation.

## 📸 Screenshots

| Welcome Screen | Home Screen | Detail Screen |
| :---: | :---: | :---: |
| ![Welcome](https://via.placeholder.com/200x400?text=Welcome+Screen) | ![Home](https://via.placeholder.com/200x400?text=Home+Screen) | ![Detail](https://via.placeholder.com/200x400?text=Detail+Screen) |

| Order Summary | Wishlist | Profile |
| :---: | :---: | :---: |
| ![Order](https://via.placeholder.com/200x400?text=Order+Summary) | ![Wishlist](https://via.placeholder.com/200x400?text=Wishlist) | ![Profile](https://via.placeholder.com/200x400?text=Profile) |

*(Note: Replace placeholder links with actual screenshots from your device/emulator)*

---

## 🚀 Topics & Concepts Covered

### 1. **Jetpack Compose Fundamentals**
- **Composable Functions:** Modular and reusable UI components.
- **State Management:** Using `remember`, `mutableStateOf`, and `mutableStateListOf` to handle UI updates and user interactions.
- **Modifiers:** Extensive use of `Modifier` for layout, styling, click handling, and spacing.

### 2. **Responsive Design**
- **Adaptive Layouts:** Using `LazyVerticalGrid` with `GridCells.Adaptive` to ensure the product grid looks great on all screen sizes (phones, tablets).
- **Flexible Components:** Using `weight` in `Row` and `Column` to distribute space proportionally.
- **BoxWithConstraints:** (Implicitly handled) ensuring text and images scale correctly.

### 3. **Navigation**
- **Navigation Compose:** Implementation of `NavHost`, `NavController`, and `composable` routes.
- **Deep Linking/Arguments:** Passing data (like `coffeeId`) between screens.
- **Bottom Navigation:** Integrated `NavigationBar` for quick access to main sections.

### 4. **Material Design 3 (M3)**
- **Scaffold:** Standard layout structure with `TopAppBar`, `BottomBar`, and `SnackbarHost`.
- **Theming:** Custom `CoffeeAppTheme` with specialized colors (Brown, Dark Gray) and typography.
- **Components:** `Card`, `Button`, `TextField`, `IconButton`, and `HorizontalDivider`.

### 5. **Advanced UI Components**
- **Lazy Lists:** `LazyRow` for categories and `LazyColumn` for orders and wishlist.
- **Graphics & Styling:** 
    - `Brush.verticalGradient` for the welcome screen overlay.
    - `RoundedCornerShape` for modern aesthetics.
    - `ContentScale.Crop` for high-quality image presentation.

---

## 🛠️ How it was Built

1.  **Architecture:** The app follows a clean separation of concerns. UI screens are located in the `UiScreens` package, and data models are in the `data` package.
2.  **Resources:** Utilized local drawables for coffee types and promotional banners.
3.  **Dependencies:**
    - `androidx.navigation:navigation-compose` for screen transitions.
    - `androidx.compose.material3` for the latest UI components.
    - `androidx.compose.material:material-icons-extended` for a rich set of icons.

---

## 🏗️ How to Build

1.  Clone the repository.
2.  Open the project in **Android Studio (Ladybug or later)**.
3.  Let Gradle sync finish.
4.  Run the `app` module on an emulator or physical device.

---

## 🗺️ Navigation Structure

- **`welcome`**: The landing page with a "Get Started" call to action.
- **`home`**: The main dashboard with search, promo, and coffee grid.
- **`detail/{coffeeId}`**: Detailed view of a specific coffee item.
- **`wishlist`**: Saved favorites.
- **`order_summary`**: Cart and checkout summary.
- **`profile`**: User account and address information.

---

*Built with ❤️ for Coffee Lovers and Developers.*
