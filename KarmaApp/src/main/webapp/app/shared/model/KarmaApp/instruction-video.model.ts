export interface IInstructionVideo {
  id?: number;
  fileName?: string;
  fileContentType?: string;
  file?: any;
}

export class InstructionVideo implements IInstructionVideo {
  constructor(public id?: number, public fileName?: string, public fileContentType?: string, public file?: any) {}
}
