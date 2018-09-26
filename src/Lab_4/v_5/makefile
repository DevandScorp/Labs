# makefile Lab_4

.SUFFIXES: .class .java

PACK=Lab_4
TARG=Test
JC=javac -g
JM=java -ea -jar
JR=jar -cfe

OBJ=$(PACK)\Quadratic.class \
    $(PACK)\Test.class

.java.class:
	$(JC) $<

run: build
	$(JM) $(TARG).jar

build: 	$(OBJ)
	$(JR) $(TARG).jar $(PACK).Test $(OBJ)

clean:
	for %%f in ($(OBJ)) do del %%f
	del $(TARG).jar

$(PACK)\Matrix.class: $(PACK)\Quadratic.java makefile

$(PACK)\Test.class: $(PACK)\Test.java makefile

# eof makefile Lab_4
