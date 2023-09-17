# BT CAR

Content
1. [Overview](#overview)
2. [Android Modules](#android-modules)
   1. [App](#app)
   2. [Common](#common)
   3. [Connectivity](#connectivity)
   4. [Data](#data)
   5. [Domain](#domain)
   6. [Menu](#menu)
   7. [Play](#play)
3. [Use Cases](#use-cases)
   1. [Menu Use Cases](#menu-use-cases)
   2. [Connection Use Cases](#connection-use-cases)
      1. [ConnectCellphoneToCarUseCase](#connectcellphonetocarusecase)
   3. [Play Use Cases](#play-use-cases)
4. [BT Connection Process](#bt-connection-process)

## Overview
TBA

## Android Modules

### App

App module.

### Common

The **common** module holds common classes and files that are used by the entire project 
cross-modules.

### Connectivity

The **connectivity** module holds classes and files that stores the logic to:

* Check the **controller** BT module existence.
* Check the **controller** BT module status.
* Create the BT communication between the phone (from now on **controller**) and the **car**.
* End the BT connection.

### Data 

Data layer (to be continued...)

### Domain

Data layer (to be continued...)

### Menu

The **menu** module holds the interface to allow users different actions and to display connection
status:

* Notify the user about the **controller** BT module existence.
* Notify the user about the **controller** BT module status.
* Display connection status between the **controller** and the **car** BT module (hardware).
* User can connect the **controller** to the **car**.
* The user can see the connection progress/status.
* The user can end the connection between the **controller** from the **car**.
* If the connection is active the user can start the process for driving the car. 
* The user can exit the app.

### Play

The **play** module holds the interface and the logic for that the user can drive the car.

## Use Cases

### Menu Use Cases

### Connection Use Cases

#### ConnectCellphoneToCarUseCase

| Configs | Description                                 |
|:-------:|:--------------------------------------------|
| Action  | Cellphone is connected through BT to the car and the user see connection progress|
| Input   | String (car MAC address)                    |
| Output  | Periodic reports on connection status and if success the user is taken to PLAY screen.|


### Play Use Cases

El usuario puede enviar datos al auto via BT
	- velocidad
	- luces on/off
	- giro izquierda/derecha
    - INPUT: byte
    - OUTPUT: Unit
    - ACTION: None
El usuario puede terminar la conexion con el auto
    - INPUT:
    - OUTPUT: Success (throwws on error)
    - ACTION: Termina la conexion BT con el auto y redirige al usuario a la pantalla MENU



## BT Connection Process

1. Get **BT Adapter** instance.
2. Check BT adapter **state**:
   1. **Null**: means **controller** has no BT capabilities and the flow should be interrupted.
   2. **Enabled**: Continue on step (3.).
   3. **Disabled**: Ask the user to turn BT on on the cellphone.
3. 
