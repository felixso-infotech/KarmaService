export interface IRegisteredUser {
  id?: number;
  profilePictureContentType?: string;
  profilePicture?: any;
  coverPhotoContentType?: string;
  coverPhoto?: any;
  userId?: number;
}

export class RegisteredUser implements IRegisteredUser {
  constructor(
    public id?: number,
    public profilePictureContentType?: string,
    public profilePicture?: any,
    public coverPhotoContentType?: string,
    public coverPhoto?: any,
    public userId?: number
  ) {}
}
