BitsyChat
=========

Minecraft plugin for Bitsy Minecraft chat

## Compiling

Linux/Mac
```bash
./gradlew clean shadowJar
```

Windows
```batch
gradlew.bat clean shadowJar
```

This should produce a jar in ./build/libs

## Configuration

The bot needs to be connected to the server you wish to link with, and dynmap needs to be installed on the server.
Discord token should be set to the bot token, guild should be set to the server name, and channel should be set to the
discord channel to receive and send messages in.

Chat sources allow you to configure the format for each chat source. %1$s is the player's name, and %2$s is the message. Colour & format codes can be used by using an ampersand.

