#!/usr/bin/env bash
set -euo pipefail

# Start one Appium server per configured server URL/port in devices.properties.
# Keep this script running in its own terminal. Change ports to match your config.
appium --address 127.0.0.1 --port 4723 &
P1=$!
appium --address 127.0.0.1 --port 4724 &
P2=$!
#appium --address 127.0.0.1 --port 4727 &
#P3=$!
#appium --address 127.0.0.1 --port 4729 &
#P4=$!

cleanup() {
  kill "$P1" "$P2" "$P3" "$P4" 2>/dev/null || true
}
trap cleanup EXIT INT TERM
wait
