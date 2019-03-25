export interface IRegisteredUser {
  id?: number;
  profilePicContentType?: string;
  profilePic?: any;
  userId?: number;
}

export class RegisteredUser implements IRegisteredUser {
  constructor(public id?: number, public profilePicContentType?: string, public profilePic?: any, public userId?: number) {}
}
