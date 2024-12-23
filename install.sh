#!/usr/bin/env bash

if [ -e build-env.sh ]; then
    source build-env.sh
else
    echo Build project first
    exit 1
fi

if [ -z "$SCALA_VERSION" ]; then
    echo "SCALA_VERSION is not set. Please run 'source target/build-env.sh' first."
    exit 1
fi

SRC=app/target/scala-$SCALA_VERSION/gistrot
DST=$HOME/bin/gistrot

echo "Replacing $DST with $SRC ?"

read -p "Are you sure? " -n 1 -r

if [[ $REPLY =~ ^[Yy]$ ]]; then
    if [ ! -e $SRC ]; then
        echo
        echo " 💔 File $SRC does not exist."
        exit 1
    fi
    rm -f $DST
    cp $SRC $DST
    echo
    echo " ✅ Done."
else
    echo
    echo
    echo "- 💀 Aborted ! "
fi
