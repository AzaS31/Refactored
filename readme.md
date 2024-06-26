### Домашнее задание. Проверка кода (из семинара 4) на соответсвие принципам SOLID.
#### Принцип единственной ответственности (Single Responsibility Principle).
##### Классы которые соответсвуют принципам SRP:
>Каждый класс должен отвечать только за одну операцию.
- Класс **Student** отвечает за представление студента и его сравнение. Соответствует SRP.
- **StudentController** управляет созданием и отображением студентов. Соответствует SRP.
- Класс **StudentGroup** управляет коллекцией студентов. Соответствует SRP.
- **StudentGroupService** управляет логикой сортировки студентов. Соответствует SRP.
- **Teacher** отвечает за представление учителя и его сравнение. Соответствует SRP.
- **TeacherGroup:** Управляет коллекцией учителей. Соответствует SRP.
- **TeacherService:** Управляет логикой сортировки учителей. Соответствует SRP.
- **TeacherView:** Отображает учителей. Соответствует SRP.
- **User:** Представляет базовый класс для пользователей. Соответствует SRP.
- **UserComparator:** Сравнивает пользователей по ФИО. Соответствует SRP.
- **UserController:** Интерфейс для управления пользователями. Соответствует SRP.
- **UserGroup:** Управляет коллекцией пользователей. Соответствует SRP.
- **UserGroupIterator:** Реализует итератор для коллекции пользователей. Соответствует SRP.
- **UserView:** Отображает пользователей. Соответствует SRP.

##### Классы которые не соответсвуют прниципам SRP:
**- TeacherController** 
Управвляет созданием учителей через интерфейс UserController.
Отображает список учителей через класс TeacherView.
Изменяет имя учителей через функцию ChangeName.
Сортирует список учителей по ФИО через класс TeacherService.
**- StudentController** 
Управвляет созданием студентов через интерфейс UserController.
Отображает список учителей через класс TeacherView.

##### Рефакторинг:
- Удаляем метод **СhangeName** из **TeacherController** и создаем интерфейс **UserModifier** для измения пользователя и имплементируем его в **TeacherService**.
- Убираем интерфейс **UserController** и подключаем его к **TeacherService**. Так как **UserController** отвечает только за создание пользователя переименуме в **UserCreator**.
- А из **TeacherService** удалеяем методы сортировки и создаем интерфейс UserSorter и имплементируем его также в **TeacherService**.
- И так, теперь мы подключаем каждый отдельный интерфейс для управлением пользователями к **TeacherService** и через **TeacherService** добавляем методы в **Контроллер**, не смешивая их в одном классе. Это способствует лучшей структурированности кода, улучшает его поддерживаемость и расширяемость.
- Также делаем и с классом **StudentController** и **StudentGroupService**.

#### Принцип открытости/закрытости (Open Closed Principle)
>Принцип открытости/закрытости (Open/Closed Principle, OCP) гласит, что программные сущности (классы, модули, функции и т.д.) должны быть открыты для расширения, но закрыты для модификации. Это означает, что поведение класса должно быть расширяемым без изменения его исходного кода.

В целом код соответсвует этому принциму, так как, нам не требуется изменение существующего кода для добавления нового функционала.

#### Принцип подстановки Барбары Лисков (Liskov’s Substitution Principle)
>Принцип подстановки Барбары Лисков (Liskov Substitution Principle, LSP) определяет, что объекты должны быть заменяемыми на экземпляры их подтипов без изменения корректности программы. Это означает, что подклассы должны быть взаимозаменяемыми с их супертипами без изменения ожидаемого поведения программы.

В нашем коде Student и Teacher являются подклассами User.
Код соответствует принципу подстановки Барбары Лисков. Классы Student и Teacher можно безопасно использовать везде, где ожидается User, не нарушая ожидаемого поведения программы. Они расширяют функциональность базового класса User, не изменяя его основных свойств и методов.

#### Принцип разделения интерфейса (Interface Segregation Principle)
>Принцип разделения интерфейса (Interface Segregation Principle, ISP) утверждает, что клиенты не должны зависеть от интерфейсов, которые они не используют. Он также подразумевает, что интерфейсы должны быть узко специализированными, чтобы они содержали только те методы, которые реально нужны клиентам.

После рефакторинга наш код управляется с узконаправленными интерфейсами такими как UserCreator UserModifier UserSorter. 
Принцип разделения интерфейса помогает создавать более гибкие и модульные системы, где клиенты зависят только от необходимых им интерфейсов, не зная о неиспользуемых методах. Текущий код демонстрирует соответствие этому принципу, предоставляя клиентам узко специализированные интерфейсы и методы для работы с учителями и студентами.

####  Принцип инверсии зависимостей (Dependency Inversion Principle)
>Принцип инверсии зависимостей (Dependency Inversion Principle, DIP) стремится к тому, чтобы высокоуровневые модули не зависели от низкоуровневых модулей, оба типа зависели от абстракций, а также детали должны зависеть от абстракций.

TeacherController, StudentController:
Зависят от абстракций UserCreator, UserModifier, UserSorter через сервисы TeacherService и StudentGroupService, что соответствует DIP.

**Рефакторинг Дублирования в коде**:
Также, я удалил ненужные классы TeacherView(выводить можно и через класс UserView), StudentGroup и TeacherGroup (так как они выполняют тоже что и UserGroup).

**Заключение**:
Наш код, после рефакторинга, демонстрирует соблюдение основных принципов SOLID. Использование интерфейсов для операций с пользователями позволяет легко добавлять новую функциональность, а отделение логики работы с данными от их отображения и управления поддерживает высокую степень модульности и переиспользования кода.
**Результат в папке Refactored.**