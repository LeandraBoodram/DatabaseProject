def generate_combinations():
  """Generates all combinations of floor, wing, and room number."""
  floors = ["B", "1", "2", "3", "4", "5", "6", "7", "8"]
  wings = ["N", "S", "E", "W"]
  room_numbers = list(range(1, 21))

  combinations = []
  for floor in floors:
    for wing in wings:
      for room_number in room_numbers:
        combinations.append((floor, wing, room_number))
  return combinations

def write_combinations_to_file(combinations, filename="combinations.txt"):
  """Writes the list of combinations to a file."""
  with open(filename, "w") as file:
    for combination in combinations:
      file.write(str(combination) + "\n")

all_combinations = generate_combinations()
write_combinations_to_file(all_combinations)


