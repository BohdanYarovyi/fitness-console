# 💪 Workout Tracker (CLI)

## ✅ Selected Task
**Task 1: Fitness Journal (Console version on Java Core)**  
A console menu-oriented application for maintaining a workout journal.
It allows the user to add, view, and delete workouts,
as well as calculate total calories burned weekly or monthly.

---

## ⚙️ Implemented Functionality
- 📌 **Add Workout** — the user enters the type, date, duration, and calories burned.
- 📋 **View All Workouts** — displays a list of all recorded workouts.
- 🗑️ **Delete Workout** — deletion by index.
-  🔥 **Calculate Weekly Calories** — sums burned calories for the week starting from a user-provided date.
- 📅 **Calculate Monthly Calories** — sums burned calories for a given month and year.
- 💾 **Data Persistence** — workouts are saved to a JSON file between sessions.
- 🕵️ **Validation** - each step is validated and guarantees the stability of the system.

---

## 🛠️ Technologies
- > The application uses an own created CLI Framework - [YaLM](https://github.com/BohdanYarovyi/YaLM).
  > This project serves as a real-world example of how to use the framework effectively.
  > During the development, a CLI framework was created and later extracted into a standalone module.
  > It is now used as an external dependency rather than being part of the program itself.
  > 
  > [YaLM](https://github.com/BohdanYarovyi/YaLM) 
  > was published to [Central Maven Repository]([https://central.sonatype.com/](https://central.sonatype.com/artifact/io.github.bohdanyarovyi/ylmenu)), and it is available for 
  > [using](https://github.com/BohdanYarovyi/YaLM?tab=readme-ov-file#-getting-started).
  
- > The program uses dependency for JSON working - [JACKSON](https://github.com/FasterXML/jackson-core).
  > It is a part of persistence layer.


---

## 📌 Notes
- Sorting **not implemented**.
- JUnit tests are **not implemented** yet.

---

## 🔗 Related Projects
- 🧩 [**YaLM (Yarovyi Lightweight Menu)**](https://github.com/BohdanYarovyi/YaLM) – The CLI framework used in this project.

---

# 🪪 Contacts
- Author: Bohdan Yarovyi
- GitHub: [@BohdanYarovyi](https://github.com/BohdanYarovyi)
- Email: bogdan.yarovoy.01@gmail.com

---

## 📄 License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
