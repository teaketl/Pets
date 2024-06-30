App.class: App.java Owner.class Cat.class Dog.class FileHandler.class
	javac App.java

Owner.class: Owner.java
	javac Owner.java

Cat.class: Cat.java Pets.class Attribute.class Color.class
	javac Cat.java

Dog.class: Dog.java Pets.class Attribute.class Color.class
	javac Dog.java

FileHandler.class: FileHandler.java
	javac FileHandler.java

.PHONY: run jar clean

run: App.class
	java App

jar: App.class Owner.class Cat.class Dog.class FileHandler.class
	jar cf myapp.jar *.class

clean:
	rm -f *.class myapp.jar
