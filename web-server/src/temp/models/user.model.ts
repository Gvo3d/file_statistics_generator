export class User implements IUser{
  id: number;
  name: string;

  get getId(): number {
    return this.id;
  }

  set setId(value: number) {
    this.id = value;
  }

  get getName(): string {
    return this.name;
  }

  set setName(value: string) {
    this.name = value;
  }

  public toString(): string {
    return 'User: { id=' + this.id + ', name=' + this.name + ' };'
  }
}

export interface IUser {
  id: number;
  name: String;

  toString():string;
}
