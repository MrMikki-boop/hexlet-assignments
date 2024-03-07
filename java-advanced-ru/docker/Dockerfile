# Используем базовый образ с установленной JDK 20
FROM eclipse-temurin:20-jdk

# Установка инструментов для сборки приложения
ARG GRADLE_VERSION=8.2
RUN apt-get update && apt-get install -yq make unzip wget

# Установка Gradle
RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip \
    && rm gradle-${GRADLE_VERSION}-bin.zip \
    && mv gradle-${GRADLE_VERSION} /opt/gradle

# Установка переменной окружения для Gradle
ENV GRADLE_HOME=/opt/gradle
ENV PATH=$PATH:$GRADLE_HOME/bin

# Копирование исходного кода приложения в контейнер
COPY . /app
WORKDIR /app

# Сборка приложения
RUN gradle build

# Экспонирование порта
EXPOSE 3000

# Запуск приложения при старте контейнера
CMD ["java", "-jar", "build/libs/app.jar"]
